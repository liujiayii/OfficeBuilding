(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-95c0f064"],{"4c7a":function(a,t,e){},8682:function(a,t,e){"use strict";var l=e("4c7a"),s=e.n(l);s.a},"8cd5":function(a,t,e){"use strict";e.r(t);var l=function(){var a=this,t=a.$createElement,e=a._self._c||t;return e("div",{staticClass:"bigbox"},[e("el-breadcrumb",{staticClass:"navsbox",attrs:{"separator-class":"el-icon-arrow-right"}},[e("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[a._v("首页")]),e("el-breadcrumb-item",[a._v("决策分析")]),e("el-breadcrumb-item",[a._v("客源统计")])],1),e("div",{staticClass:"search-box"},[e("div",{staticClass:"search-boxitem title"},[a._v("\n        搜索\n      ")]),e("div",{staticClass:"search-boxitem"},[e("el-select",{attrs:{placeholder:"门店",clearable:""},on:{change:function(t){return a.seachxq(a.valueMd)}},model:{value:a.valueMd,callback:function(t){a.valueMd=t},expression:"valueMd"}},a._l(a.optionsMd,function(a){return e("el-option",{key:a.value,attrs:{label:a.label,value:a.value}})}),1)],1),e("div",{staticClass:"search-boxitem"},[e("div",{staticClass:"block"},[e("el-date-picker",{attrs:{type:"daterange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期"},on:{change:function(t){return a.seachxq(a.valueData)}},model:{value:a.valueData,callback:function(t){a.valueData=t},expression:"valueData"}})],1)])]),e("el-table",{staticStyle:{width:"100%","margin-top":"20px"},attrs:{"row-class-name":a.tableRowClassName,"span-method":a.objectSpanMethod,"header-cell-style":a.tableHeaderColor,data:a.tableData,border:""}},[e("el-table-column",{attrs:{prop:"groupName",label:"ID",width:"180"}}),e("el-table-column",{attrs:{prop:"name",label:"姓名"}}),e("el-table-column",{attrs:{prop:"sumome",label:"意向客户数量"}}),e("el-table-column",{attrs:{prop:"sumtwo",label:"已成交客户数量"}}),e("el-table-column",{attrs:{prop:"sum",label:"总计"}})],1)],1)},s=[],o=(e("7f7f"),{name:"decisionTourist",data:function(){return{valueData:"",optionsMd:[],valueMd:null,valueClass:null,optionswh:[{value:" 1",label:"维护时间"},{value:"2",label:"录入时间"}],valuewh:null,tableData:[]}},methods:{tableRowClassName:function(a){var t=a.row;a.rowIndex;return"平均"==t.name?"warning-row":"合计"==t.name?"success-row":""},getsel:function(){var a=this;this.$axios.post("backShop/listAllOnPage.action",{pageSize:10,pageNum:1}).then(function(t){for(var e=0;e<t.data.data.list.length;e++){var l={};l.value=t.data.data.list[e].id,l.label=t.data.data.list[e].name,a.optionsMd.push(l)}})},objectSpanMethod:function(a){var t=a.row,e=(a.column,a.rowIndex,a.columnIndex);if(0===e)return t.row?{rowspan:t.row,colspan:1}:{rowspan:0,colspan:0}},tableHeaderColor:function(a){a.row,a.column;var t=a.rowIndex;a.columnIndex;if(0===t)return"height: 50px!important;overflow: hidden; line-height: 28px;  border-bottom: 1px solid #ebeef5;background-color: #f5f7fa"},getlistAlldoor:function(){var a=this;this.$axios.post("user/selectAllSome.action",{shopId:this.valueMd,startTime:this.valueData[0]?this.valueData[0]:"",endTime:this.valueData[1]?this.valueData[1]:""}).then(function(t){a.tableData=[],a.listArr=[];for(var e=0,l=0,s=0;s<t.data.data.length;s++){var o={},r={};a.listArr.push(t.data.data[s].list.length),t.data.data[s].list[0].userListVo.row=t.data.data[s].list.length+2;for(var n=0;n<t.data.data[s].list.length;n++){e+=t.data.data[s].list[n].userListVo.sumome,l+=t.data.data[s].list[n].userListVo.sumtwo;var i=t.data.data[s].list[n].userListVo.sumome+t.data.data[s].list[n].userListVo.sumtwo;t.data.data[s].list[n].userListVo.groupName=t.data.data[s].groupName,t.data.data[s].list[n].userListVo.name=t.data.data[s].list[n].name,t.data.data[s].list[n].userListVo.sum=i,a.tableData.push(t.data.data[s].list[n].userListVo),o.sumome=e,o.sumtwo=l,o.sum=e+l,o.sum=o.sum.toFixed(2),o.name="合计";var u=t.data.data[s].list.length;r.singular=l/t.data.data[s].list.length,r.brokerage=e/t.data.data[s].list.length,r.sum=e/u+l/u,r.sum=r.sum.toFixed(2),r.name="平均"}a.tableData.push(o),a.tableData.push(r)}})},seachxq:function(){this.getlistAlldoor()}},mounted:function(){this.getlistAlldoor(),this.getsel()}}),r=o,n=(e("8682"),e("2877")),i=Object(n["a"])(r,l,s,!1,null,"290c558a",null);t["default"]=i.exports}}]);