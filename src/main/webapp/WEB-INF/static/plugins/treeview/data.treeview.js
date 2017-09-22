var Tree = function () {
    var inited = false;
    var $selectableTree;
    var $selectableNode;
    var $old_data;
    var option;
    //保存已经展开过的节点
    var expendedNode = [];

    function init_popMenu(options) {
        if (!$.isArray(options.MenuData)) {
            return false;
        }
        try {
            $('#' + options.treeId).smartMenu(options.MenuData, "li", {
                name: "tree", //当前生成右键菜单元素的指定id，默认前缀：“smartMenu_”
                beforeShow: function () { //显示右键菜单前执行事件
                    if ($(this).hasClass("node-selected")) return false;
                    $(this).click();
                },
                $selectableTree: $selectableTree
            });
        } catch (e) {
            console.error(e);
        }
    }

    function init_treeview(options) {
        option = options;
        $selectableTree = $('#' + options.treeId).treeview({
            color: "#428bca",
            expandIcon: 'glyphicon glyphicon-plus-sign',
            collapseIcon: 'glyphicon glyphicon-minus-sign',
            showBorder: false,
            showIcon: true,
            levels: 1,
            showTags: true,
            multiSelect: options.multiSelect || false,
            searchResultColor: "",
            data: options.data,
            onNodeSelected: function (event, node) {
                $selectableNode = node;
                if (options.onSelected) {
                    options.onSelected(event, node);
                }
            },
            onNodeUnselected: function (event, node) {
                if (options.onUnSelected) {
                    options.onUnSelected(event, node)
                }
            },
            onNodeExpanded: function (event, node) {
                //判断该节点是否被展开过
                if (expendedNode.indexOf(node.dir_code) < 0) {
                    //如果未被展开过请求数据并加载新节点
                    //防止重复加载导致的问题
                    expendedNode.push(node.dir_code);
                    //如果url后面带参数，点击展开之后，就去掉参数
                    options.requestUrl = options.requestUrl.split('?')[0];
                    add_node(node, node.nodeId, options);

                }
            }
        });
        if (options.firstNodeSelect && !inited) {
            //  $('#treeview>ul>li').eq(0).trigger('click');
            $selectableTree.treeview('selectNode', [0, {silent: false}])
        }


        // $selectableTree.treeview('selectNode', [ '', { silent: true } ]);
    }

    function selected_event(event, node) {
        $selectableNode = node;
    }

    function tree_format(result, options) {
        if (result.length == 0) return null;
        var aaData = [];
        result.forEach(function (v) {
            var temp_json = {};
            temp_json.text = v[options.name];
            temp_json.dir_code = v[options.code];
            temp_json.nodes = tree_format(v.childs, options);

            //禁用父级节点
            if (typeof options.parentIsChecked != "undefined" && !options.parentIsChecked) {
                //如果该节点拥有子节点则禁用
                temp_json.selectable = !(v.childs.length > 0);
            }
            //第一级不可选中
            if (options.firstNodeIsChecked) {
                temp_json.selectable = !(temp_json.dir_code.length < 2)
            }

            //禁用某一个节点
            if (options.disabledNode == temp_json.dir_code) {
                temp_json.state = {
                    disabled: true
                }
            }
            aaData.push(temp_json);
        });
        return aaData;
    }

    function load_treeview(options, param) {
        var init_treeview = function () {
            var promise = $.Deferred();
            $.post(options.requestUrl, param, function (d) {
                var result;
                //判断result是否为空
                if (d.result) {
                    if (typeof d.result === "object") {
                        result = d.result;
                    } else {
                        result = JSON.parse(d.result);
                    }
                    promise.resolve(result.data);
                }

            }, "json");
            return promise.promise();
        };
        return init_treeview().then(function (result) {
            return tree_format(result, options);
        });
    }

    function add_node(node, node_id, options) {
        return load_treeview(options, {fcode: node.dir_code}).then(function (aaData) {
            aaData.forEach(function (v) {
//				console.log(v);
                $selectableTree.treeview("addNode", [node_id, {node: v}]);
            })
        });
    }

    return {
        init: function (options) {
            return load_treeview(options, {fcode: "root"}).then(function (aaData) {
                $old_data = aaData;
                options.data = aaData;
                init_treeview(options);
                init_popMenu(options);
                inited = inited || !inited;
                return aaData;
            });
        },
        getTree: function () {
            return $selectableTree;
        },
        addNode: function (dir_name, dir_code, nodeId, state) {
            if (!nodeId) {			            //不存在数据，新增第一条数据
                return this.init(option).then(function () {
                    var selectNode = null;
                    var aaData = $selectableTree.treeview("getUnselected");
                    aaData.forEach(function (v) {
                        if (v.dir_code == dir_code && v.text == dir_name) {
                            selectNode = v;
                            return false;
                        }
                    });
                    $selectableTree.treeview('selectNode', [selectNode, {silent: true}]);
                    option.onSelected(null, $selectableTree.treeview("getSelected")[0]);
                });
            }
            var node = $selectableTree.treeview("getParent", [($selectableTree.treeview('getSelected')[0])]);
            if (state == "1") {						//添加同级
                if (!(node instanceof jQuery)) {						//是否根目录
                    //非根目录添加同级
                    $selectableTree.treeview("addNode", [parseInt(node.nodeId), {
                        node: {
                            text: dir_name,
                            dir_code: dir_code,
                            nodes: null,
                            state: {
                                checked: false,
                                disabled: false,
                                expanded: false,
                                selected: false
                            }
                        }
                    }]);
                    return add_node(node, node.nodeId, option).then(function () {
                        var selectNode;
                        node.nodes.forEach(function (v, k) {
                            if (v.dir_code == dir_code && v.text == dir_name) {
                                selectNode = v;
                                return false;
                            }
                        });
                        $selectableTree.treeview('selectNode', [selectNode, {silent: true}]);
                    }).then(function () {
                        $selectableTree.treeview('expandNode', [node, {levels: 1, silent: true}]);
                        option.onSelected(null, $selectableTree.treeview("getSelected")[0]);
                    });
                } else {
                    //根目录添加同级
                    return this.init(option).then(function () {
                        var selectNode;
                        var aaData = $selectableTree.treeview("getUnselected");
                        aaData.forEach(function (v) {
                            if (v.dir_code == dir_code && v.text == dir_name) {
                                selectNode = v;
                                return false;
                            }
                        });
                        $selectableTree.treeview('selectNode', [selectNode, {silent: true}]);
                        option.onSelected(null, $selectableTree.treeview("getSelected")[0]);
                    });
                }
            } else { 		            //添加子级
                node = ($selectableTree.treeview('getSelected')[0]);
                $selectableTree.treeview("addNode", [parseInt(nodeId), {
                    node: {
                        text: dir_name,
                        dir_code: dir_code,
                        nodes: null,
                        state: {
                            checked: false,
                            disabled: false,
                            expanded: false,
                            selected: false
                        }
                    }
                }]);
                return add_node(node, node.nodeId, option).then(function () {
                    var selectNode;
                    node.nodes.forEach(function (v, k) {
                        if (v.dir_code == dir_code && v.text == dir_name) {
                            selectNode = v;
                            return false;
                        }
                    });
                    $selectableTree.treeview('selectNode', [selectNode, {silent: true}]);
                }).then(function () {
                    $selectableTree.treeview('expandNode', [node, {levels: 1, silent: true}]);
                    option.onSelected(null, $selectableTree.treeview("getSelected")[0]);
                });
            }

        },
        changeNodeText: function (nodeId, params) {
            $selectableTree.treeview("changeNodeText", [parseInt(nodeId), params]);
        },
        findSelectableNodes: function () {
            return $selectableNode;
        }
    }
}

/*define(['.', 'bootstrap-treeview'], function ($) {
    $(document).on('click', 'span[data-toggle=showTree]', function (e) {
        e.stopPropagation();
        var treeArr = $('.tree');
        treeArr.each(function (n, v) {
            if (!$(v).hasClass('hidden')) {
                if ($(e.target).parent().next().attr('id') != $(v).attr('id')) {
                    $(v).addClass('hidden');
                }
            }

        });
        if ($(e.target).parent())
            $($(this).attr('data-target')).removeClass('hidden');
//  $('.zz').removeClass('hidden');
    });
    $(document).on('click', function (e) {
        if (!$(e.target).hasClass('list-group-item') && !$(e.target).parent().hasClass('list-group-item')) {
            $('.tree').addClass('hidden');
        } else {
            return false;
        }
    });
})*/

/**
 *
 * @param treeId 节点ID
 * @param showInputId 界面显示输入框ID
 * @param hideInputId 隐藏输入框ID
 */
function initRelItemMenutree(treeIds, showInputId, hideInputId) {
    var ItemMenutree = new Tree();
    var selected = [];
    var selectedId = [];
    ItemMenutree.init({
        requestUrl: CONTEXT_PATH + '/admin/Organize_getOrganizeByPidHasBusi',
        treeId: treeIds,
        name: "org_shortname",
        code: 'org_code',
        parentIsChecked: true,
        multiSelect: false,
        onSelected: function (e, n) {
            selected.push(n.text);
            selectedId.push(n.dir_code);
            $('#' + showInputId).val(selected.join('；')).removeClass('parsley-error').parent().find('ul').remove();
            $('#' + hideInputId).val(selectedId.join(','));
            initItemBusinesstree('', selectedId.join(','));

        },
        onUnSelected: function (e, n) {
            var text = n.text;
            var index = selected.indexOf(text);
            selected.splice(index, 1);
            selectedId.splice(index, 1);
            $('#' + showInputId).val(selected.join('；'));
            $('#' + hideInputId).val(selectedId.join(','));
            initItemBusinesstree('', selectedId.join(','));
        }
    });
}
function initItemBusinesstree(fcodes, orgCode) {
    var businessItemMenutree = new Tree();
    var selected = [];
    var selectedId = [];
    businessItemMenutree.init({
        requestUrl: CONTEXT_PATH + '/admin/Dataset_getBusiniss?fcode=' + fcodes + '&org_codes=' + orgCode,
        treeId: 'businessItemMenutree',
        name: "ACTIVITY_NAME",
        code: 'ID',
        parentIsChecked: true,
        multiSelect: true,
        onSelected: function (e, n) {
            selected.push(n.text);
            selectedId.push(n.dir_code);
            $('#item_business_name').val(selected.join('；')).removeClass('parsley-error').parent().find('ul').remove();
            $('#item_business_code').val(selectedId.join(','));

        },
        onUnSelected: function (e, n) {
            var text = n.text;
            var index = selected.indexOf(text);
            selected.splice(index, 1);
            selectedId.splice(index, 1);
            $('#item_business_name').val(selected.join('；'));
            $('#item_business_code').val(selectedId.join(','));
        }
    });
}