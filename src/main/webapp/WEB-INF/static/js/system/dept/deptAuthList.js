var tableSelector = '#systemAuthDeptTableId';

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
                var treeObj=$.fn.zTree.getZTreeObj("treeDemo"), selectNodes=treeObj.getCheckedNodes(true),ids=[];
                ////////////////////////////////////////////////////
                var resultList = [];
                var tempList = [];
                for(var i in selectNodes){
                    var node = selectNodes[i];
                    if(node.check_Child_State!=1){
                        tempList.push(node);
                    }
                }
                if(tempList.length > 0){
                    for(var i in tempList){
                        var flag = false;
                        var tempNode = tempList[i];
                        for(var j in tempList){
                            if(tempNode.pId == tempList[j].id){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            resultList.push(tempNode);
                        }
                    }
                }
                for (var i = 0; i < resultList.length; i++) {
                    ids.push(resultList[i].id);
                }
                ////////////////////////////////////////////////////
                console.log(ids);
                var params;
                if(tp==="dept"){
                    params={
                        authObjId:id,
                        deptIds : ids.join(','),
                        authType : tp
                    }
                }
                if(tp==="dir"){
                    params={
                        authObjId:id,
                        classifyIds :ids.join(','),
                        authType : tp
                    }
                }
                $.commonAjax({
                    url: basePathJS + "/system/deptAuthority/doEdit",
                    data:params,
                    success: function (result) {
                        console.log(result)
                        layer.msg(result.msg);
                        layer.close(idx);
                    }
                })
            }
        })
        // -----------------

        $.get(url2,function(data){
            var dd=data.content.selected,udata=[];
            if(dd.length){
                for(var i=0;i<dd.length;i++){
                    if(tp==="dir"){
                        udata.push(dd[i].classifyId)//deptId
                    }
                    if(tp==="dept"){
                        udata.push(dd[i].deptId)//classifyId
                    }
                }
            }
         ////////////////////////////////////////////////////////////////////////////
            console.log(udata)
            $.get(url,function(data){
                console.log(data)
                if(tp==="dept"){
                    var nodeObjs = data.content.selectData;
                    var selectObjs = data.content.selected
                    var setting = {
                        check: {
                            enable: true,
                            chkboxType: { "Y": "ps", "N": "ps" }
                            //chkStyle: "radio",
                            //radioType: "level"
                        },
                        data: {
                            simpleData: {
                                enable: true
                            }
                        }
                    };
                    var zNodes =[];
                    for(var i in nodeObjs){
                        zNodes[i] = {
                            'id': nodeObjs[i].id,
                            'name': nodeObjs[i].deptName,
                            'isParent': (nodeObjs[i].isLeaf ? false : true),
                        }
                    }
                    if(udata.length){
                        for(var i=0;i<udata.length;i++){
                            for(var j in zNodes){
                                if(zNodes[j].id===udata[i]) {
                                    zNodes[j] = {
                                        'id':zNodes[j].id,
                                        'name': zNodes[j].name,
                                        'isParent':zNodes[j].isParent,
                                        'checked':true,
                                        'disabled':true
                                    }
                                }
                            }
                        }
                    }
                    // console.log(zNodes)
                }
                if(tp==="dir"){
                    var nodeObjs = data.content.vo;
                    var setting = {
                        check: {
                            enable: true,
                            chkboxType: { "Y": "ps", "N": "ps" }
                        },
                        data: {
                            simpleData: {
                                enable: true
                            }
                        }
                    };
                    var zNodes =[];
                    for(var i in nodeObjs){
                        zNodes[i] = {
                            'id': nodeObjs[i].id,
                            'name': nodeObjs[i].classifyName,
                            'fid': nodeObjs[i].id,
                            'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)
                        }
                    }
                    if(udata.length){
                        for(var i=0;i<udata.length;i++){
                            for(var j in zNodes){
                                if(zNodes[j].id===udata[i]) {
                                    zNodes[j] = {
                                        'id':zNodes[j].id,
                                        'name': zNodes[j].name,
                                        'isParent':zNodes[j].isParent,
                                        'checked':true,
                                        'disabled':true
                                    }
                                }
                            }
                        }
                    }
                }
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            })
            //////////////////////////////////////////////////////////////////////////// end

        })
}