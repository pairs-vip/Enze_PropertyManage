(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0db486"],{"6ecd":function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-tabs",{staticStyle:{width:"1650px"},on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:"转交",name:"first"}},[a("div",{staticStyle:{"margin-top":"20px"}},[a("el-button",{attrs:{type:"primary"}},[e._v("新增转移单")]),a("el-button",{attrs:{type:"primary"},on:{click:e.outExe}},[e._v("打印转移单")]),a("label",{staticStyle:{"font-size":"15px","margin-left":"10px"}},[e._v("审核状态: ")]),a("el-select",{staticStyle:{"padding-right":"10px"},attrs:{filterable:"",clearable:"",placeholder:"请选择分类"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1),a("label",{staticStyle:{"font-size":"15px","margin-left":"10px"}},[e._v("选择日期: ")]),a("el-date-picker",{attrs:{type:"daterange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.value1,callback:function(t){e.value1=t},expression:"value1"}}),a("label",{staticStyle:{"font-size":"15px","margin-left":"10px"}},[e._v("部门/人: ")]),a("el-select",{staticStyle:{"padding-right":"10px"},attrs:{filterable:"",clearable:"",placeholder:"请选择分类"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{"margin-top":"20px"},attrs:{id:"exportExcel",data:e.list,"element-loading-text":"Loading",border:"",fit:"","highlight-current-row":""}},[a("el-table-column",{attrs:{align:"center",label:"ID",width:"95"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.$index)+" ")]}}])}),a("el-table-column",{attrs:{label:"Title"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.row.number)+" ")]}}])}),a("el-table-column",{attrs:{label:"Author",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.pname))])]}}])}),a("el-table-column",{attrs:{label:"Pageviews",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.row.remark)+" ")]}}])}),a("el-table-column",{attrs:{align:"center",prop:"created_at",label:"Display_time",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),a("span",[e._v(e._s(t.row.date))])]}}])})],1),a("el-pagination",{staticStyle:{"margin-top":"20px","text-align":"center"},attrs:{"current-page":e.page,"page-sizes":[5,10,20],"page-size":e.limit,layout:"prev, pager, next , jumper , -> , total, sizes ",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.getLists}})],1),a("el-tab-pane",{attrs:{label:"回调",name:"second"}},[a("div",{staticStyle:{"margin-top":"20px"}},[a("el-select",{staticStyle:{"padding-right":"10px"},attrs:{filterable:"",clearable:"",placeholder:"请选择分类"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1),a("el-button",{attrs:{type:"primary",icon:"el-icon-search"}},[e._v("搜索")]),a("el-button",{attrs:{type:"primary"},on:{click:e.outExe}},[e._v("导出")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{"margin-top":"20px"},attrs:{id:"exportExcel",data:e.list,"element-loading-text":"Loading",border:"",fit:"","highlight-current-row":""}},[a("el-table-column",{attrs:{align:"center",label:"ID",width:"95"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.$index)+" ")]}}])}),a("el-table-column",{attrs:{label:"Title"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.row.number)+" ")]}}])}),a("el-table-column",{attrs:{label:"Author",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.pname))])]}}])}),a("el-table-column",{attrs:{label:"Pageviews",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.row.remark)+" ")]}}])}),a("el-table-column",{attrs:{align:"center",prop:"created_at",label:"Display_time",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("i",{staticClass:"el-icon-time"}),a("span",[e._v(e._s(t.row.date))])]}}])})],1),a("el-pagination",{staticStyle:{"margin-top":"20px","text-align":"center"},attrs:{"current-page":e.page,"page-sizes":[5,10,20],"page-size":e.limit,layout:"prev, pager, next , jumper , -> , total, sizes ",total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.getLists}})],1)],1)],1)},n=[],i=a("1da1"),r=(a("d81d"),a("96cf"),{filters:{statusFilter:function(e){var t={published:"success",draft:"gray",deleted:"danger"};return t[e]}},data:function(){return{list:[],listLoading:!0,page:1,limit:9,total:10,input3:"",select:"",options:[{value:"选项1",label:"黄金糕"},{value:"选项2",label:"双皮奶"},{value:"选项3",label:"蚵仔煎"}],value:"",value1:"",activeName:"first"}},mounted:function(){this.getLists()},methods:{handleClick:function(e,t){console.log(e,t)},getLists:function(){var e=arguments,t=this;return Object(i["a"])(regeneratorRuntime.mark((function a(){var l,n,i,r;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return l=e.length>0&&void 0!==e[0]?e[0]:1,t.page=l,t.listLoading=!0,n=t.page,i=t.limit,a.next=6,t.$API.table.getList({page:n,limit:i});case 6:r=a.sent,console.log(r),2e4==r.code&&(t.list=r.data[0]),t.listLoading=!1;case 10:case"end":return a.stop()}}),a)})))()},handleSizeChange:function(e){this.limit=limit,this.getLists()},outExe:function(){var e=this;this.$confirm("此操作将导出excel文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.excelData=e.list,e.export2Excel()})).catch((function(){}))},export2Excel:function(){var e=this;Promise.all([a.e("chunk-002986e2"),a.e("chunk-7682ec82")]).then(function(){var t=a("cad6"),l=t.export_json_to_excel,n=["Author","Pageviews"],i=["pname","remark"],r=e.excelData,o=e.formatJson(i,r);l(n,o,"测试导出excel")}.bind(null,a)).catch(a.oe)},formatJson:function(e,t){return t.map((function(t){return e.map((function(e){return t[e]}))}))}}}),o=r,s=a("2877"),c=Object(s["a"])(o,l,n,!1,null,null,null);t["default"]=c.exports}}]);