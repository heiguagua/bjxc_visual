var tableSelector = '#systemDeptTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/dept/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptName',
            title: '组织机构名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAlias',
            title: '组织机构简称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptCode',
            title: '组织机构编码',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactMan',
            title: '联系人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactPhone',
            title: '联系电话',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAddress',
            title: '地址',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptDesc',
            title: '描述',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            width: '18%',
            formatter : function (value) {
                var allotBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAndDeptAllot(\"" + value + "\",\"dir\")'><i class='fa fa-chain'></i>目录分配</a>";
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAndDeptAllot(\"" + value + "\",\"dept\")'><i class='fa fa-pencil-square-o'></i> 部门分配</a>";
                // var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteDept(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
            return allotBtn + OPERATION_SEPARATOR + editBtn + OPERATION_SEPARATOR   ;
            }
        }],
});

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey : searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

/*function addDept() {
    add('新增组织机构',basePathJS + '/system/dept/add');
}

function allotDept(id) {
    update('编辑组织机构',basePathJS + '/system/dept/edit' , id );
}

function editDept(id) {
    update('编辑组织机构',basePathJS + '/system/dept/edit' , id );
}*/

function deleteDept(id) {
    var url = basePathJS + "/system/dept/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}

function  dirAndDeptAllot(id,authType) {
    var url,url2 = basePathJS + "/system/deptAuthority/editLoad?id="+id+"&authType="+authType;;
  if(authType==="dir"){
    url= basePathJS+'/dirClassify/authorityList';
      getTree('目录分配',url,500,300,id,url2,'dir')
  }
    if(authType==="dept"){
        url= basePathJS+'/system/dept/getDeptSelectDataList';
        getTree('部门分配',url,500,300,id,url2,'dept')
    }
}


function getTree(title, url,width, height,id,url2,tp) {
        // ----------------
       var idx= layer.open({
            offset: '100px',
            type:1,
            title:title,
            area: [width+'px', height+'px'],
            content:'<ul id="treeDemo" class="ztree"></ul>',
            btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
            yes :function(index, layero){
                var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
                        selectNodes=treeObj.getCheckedNodes(true),ids=[];

                if (selectNodes.length > 0) {
                    var node = selectNodes[0].getParentNode();
                }
                console.log("node",node)
                console.log("<<<<<<<<<<<<")
                console.log(selectNodes)
                console.log(treeObj.getParentNode())


                //如果选中了父节点的所有子节点，deptIds为父节点的id，否则，为子节点的id
                for (var i in selectNodes){
                    var bl = true;
                    if (selectNodes[i].level === 0){
                        console.log(selectNodes[i].level)
                        // childrens = selectNodes[i].children;
                        var childrenArr = getChildren(selectNodes);
                            for (var j in childrenArr){
                                var ischeck= childrenArr[j].check;
                                if (!ischeck){
                                    bl = false;
                                    var deptId = childrenArr[j].id
                                    console.log("deptId" ,deptId)
                                    //deptIds为子节点Id
                                } else {
                                    //deptIds为父节点Id
                                    console.log("参数为父节点Id")
                                }
                            }


                    }

                }
                    for(var i=0;i<selectNodes.length;i++){
                        ids.push(selectNodes[i].id);
                    }

                   /*  $.commonAjax({
                    url: basePathJS + "/system/deptAuthority/doEdit",
                    data:{
                        authObjId:id,
                        deptIds : ids.join(','),
                        authType : tp
                    },
                    success: function (result) {
                        layer.msg(result.msg);
                        layer.close(idx);
                    }
                    })*/
                // console.log(nodes)
                // console.log("点击确认")
            }
        })
        // -----------------

        $.get(url2,function(data){
            console.log("<<<<<<<<<<<")
            console.log(data.content.selected)
            var selectObjs = data.content.selected,zNodes=[];
            for (var i in selectObjs) {
                zNodes.push(nodeObjs[i].id)
            }
            console.log(zNodes)

        })
        $.get(url,function(data){
            console.log(data.content.selectData)
            var nodeObjs = data.content.selectData;
            var selectObjs = data.content.selected
            var setting = {
                check: {enable: true,chkboxType:  { "Y" : "ps", "N" : "ps" }},
                data: {
                    simpleData: {
                        enable: true
                    }
                }
        };
            var zNodes =[
                { id:1, pId:0, name:"随意勾选 1", open:true},
                { id:11, pId:1, name:"随意勾选 1-1", open:true},
                { id:111, pId:11, name:"随意勾选 1-1-1"},
                { id:112, pId:11, name:"随意勾选 1-1-2"},
                { id:12, pId:1, name:"随意勾选 1-2", open:true},
                { id:121, pId:12, name:"随意勾选 1-2-1"},
                { id:122, pId:12, name:"随意勾选 1-2-2"},
                { id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
                { id:21, pId:2, name:"随意勾选 2-1"},
                { id:22, pId:2, name:"随意勾选 2-2", open:true},
                { id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
                { id:222, pId:22, name:"随意勾选 2-2-2"},
                { id:23, pId:2, name:"随意勾选 2-3"}
            ];
            // var zNodes =[];

            /*for(var i in nodeObjs){
                zNodes[i] = {
                    'id': nodeObjs[i].id,
                    'name': nodeObjs[i].deptName,
                    'isParent': (nodeObjs[i].isLeaf ? false : true),
                    // checked:true
                }
                for (var i in selectObjs) {
                    if(selectObjs[i].id === nodeObjs[i].id) {
                        zNodes[i].checked=true;
                    }

                }
            }*/

            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        })
}



function getChildren(dd) {
    if (dd.length){
        for (var k in dd){
            if (dd[k].children){
                getChildren(dd[k].children)
            }else {
                return dd[k]
            }
        }
    }

}