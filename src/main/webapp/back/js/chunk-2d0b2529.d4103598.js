(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b2529"],{"242c":function(t,a,e){"use strict";e.r(a);var n=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"esf bigbox"},[e("div",{},[e("el-breadcrumb",{staticClass:"navsbox",attrs:{"separator-class":"el-icon-arrow-right"}},[e("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[t._v("首页")]),e("el-breadcrumb-item",[t._v("客户管理")]),e("el-breadcrumb-item",[t._v("客户列表")])],1),[e("el-table",{staticStyle:{width:"602px",margin:"0 auto"},attrs:{"header-cell-style":t.tableHeaderColor,data:t.tableData,border:""}},[e("el-table-column",{attrs:{prop:"phones",label:"用户电话",width:"300px"}}),e("el-table-column",{attrs:{prop:"state_time",label:"注册时间",width:"300px"}})],1),e("el-pagination",{attrs:{small:"",layout:"prev, pager, next","current-page":t.currentPage,total:t.count},on:{"update:currentPage":function(a){t.currentPage=a},"update:current-page":function(a){t.currentPage=a},"current-change":function(a){return t.changnum(t.currentPage)}}})]],2)])},r=[],o={name:"Customerlist",data:function(){return{currentPage:1,count:null,tableData:[]}},methods:{changnum:function(t){this.getlist(t)},tableHeaderColor:function(t){t.row,t.column;var a=t.rowIndex;t.columnIndex;if(0===a)return"height: 50px!important;overflow: hidden; line-height: 28px;  border-bottom: 1px solid #ebeef5;background-color: #f5f7fa"},getlist:function(){var t=this;this.$axios.post("client/selectClient.action",{page:1,limit:10}).then(function(a){t.tableData=a.data.data.data,t.count=a.data.data.count;for(var e=0;e<a.data.data.data.length;e++)a.data.data.data[e].state_time=t.formatData(a.data.data.data[e].state_time)})},formatData:function(t){var a=new Date(t),e=a.getFullYear(),n=a.getMonth()+1,r=a.getDate();n=n<10?"0"+n:n,r=r<10?"0"+r:r;return e+"-"+n+"-"+r}},mounted:function(){this.getlist()}},l=o,i=e("2877"),c=Object(i["a"])(l,n,r,!1,null,"194409b8",null);a["default"]=c.exports}}]);