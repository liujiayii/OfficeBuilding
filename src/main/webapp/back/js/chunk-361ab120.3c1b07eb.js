(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-361ab120"],{"8e02":function(t,s,a){"use strict";var e=a("9d71"),r=a.n(e);r.a},"9d71":function(t,s,a){},cc4c:function(t,s,a){"use strict";a.r(s);var e=function(){var t=this,s=t.$createElement,a=t._self._c||s;return a("div",{staticClass:"bigbox"},[a("el-breadcrumb",{staticClass:"navsbox",attrs:{"separator-class":"el-icon-arrow-right"}},[a("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[t._v("首页")]),a("el-breadcrumb-item",[t._v("房源管理")]),a("el-breadcrumb-item",[t._v("所有房源")]),a("el-breadcrumb-item",[t._v("房源详情")])],1),a("div",{staticClass:"box"},[a("h1",[t._v("经纪人信息")]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人姓名：")]),a("span",[t._v(t._s(t.detailsArr.real_name))])])]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人登录名：")]),a("span",[t._v(t._s(t.detailsArr.user_name))])])]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人电话：")]),a("span",[t._v(t._s(t.detailsArr.phonemunber))])])]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人生日：")]),a("span",[t._v(t._s(t._f("formatDate")(t.detailsArr.birthday)))])])]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人头像：")]),a("span",[a("img",{attrs:{src:t.detailsArr.picture||"",alt:""}})])])]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人权限：")]),t._l(t.rolesArr,function(s,e){return a("span",[t._v(t._s(s.name))])})],2)]),a("div",{staticClass:"list"},[a("p",[a("span",{staticClass:"tit"},[t._v("经纪人小组：")]),a("span",[t._v(t._s(t.detailsArr.shop?t.detailsArr.shop.name:""))]),a("span",[t._v(t._s(t.detailsArr.group?t.detailsArr.group.name:""))])])])])],1)},r=[],i={name:"housesdetails",data:function(){return{id:this.$route.query.id,detailsArr:[],rolesArr:[]}},methods:{get:function(){var t=this;this.$axios.post("BackBroker/getById.action",{id:this.$route.query.id}).then(function(s){if(t.detailsArr=s.data.data,s.data.data.roles.length>0)for(var a=0;a<s.data.data.roles.length;a++)t.rolesArr.push(s.data.data.roles[a]);t.formatDate(s.data.data.birthday)}).catch(function(t){console.log(t)})}},filters:{formatDate:function(t){var s=new Date(t),a=s.getFullYear(),e=s.getMonth()+1;e=e<10?"0"+e:e;var r=s.getDate();r=r<10?"0"+r:r;var i=s.getHours();i=i<10?"0"+i:i;var n=s.getMinutes();n=n<10?"0"+n:n;var l=s.getSeconds();return l=l<10?"0"+l:l,a+"-"+e+"-"+r+" "+i+":"+n+":"+l}},mounted:function(){window.sessionStorage.setItem("pathids",this.$route.fullPath),this.get()}},n=i,l=(a("8e02"),a("2877")),o=Object(l["a"])(n,e,r,!1,null,"b340dc4c",null);s["default"]=o.exports}}]);