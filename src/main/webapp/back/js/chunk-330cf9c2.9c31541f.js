(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-330cf9c2"],{"3e94":function(t,e,o){"use strict";var i=o("c9fe"),s=o.n(i);s.a},ac6a:function(t,e,o){for(var i=o("cadf"),s=o("0d58"),a=o("2aba"),l=o("7726"),r=o("32e9"),n=o("84f2"),u=o("2b4c"),c=u("iterator"),m=u("toStringTag"),f=n.Array,d={CSSRuleList:!0,CSSStyleDeclaration:!1,CSSValueList:!1,ClientRectList:!1,DOMRectList:!1,DOMStringList:!1,DOMTokenList:!0,DataTransferItemList:!1,FileList:!1,HTMLAllCollection:!1,HTMLCollection:!1,HTMLFormElement:!1,HTMLSelectElement:!1,MediaList:!0,MimeTypeArray:!1,NamedNodeMap:!1,NodeList:!0,PaintRequestList:!1,Plugin:!1,PluginArray:!1,SVGLengthList:!1,SVGNumberList:!1,SVGPathSegList:!1,SVGPointList:!1,SVGStringList:!1,SVGTransformList:!1,SourceBufferList:!1,StyleSheetList:!0,TextTrackCueList:!1,TextTrackList:!1,TouchList:!1},p=s(d),h=0;h<p.length;h++){var v,b=p[h],g=d[b],C=l[b],L=C&&C.prototype;if(L&&(L[c]||r(L,c,f),L[m]||r(L,m,b),n[b]=f,g))for(v in i)L[v]||a(L,v,i[v],!0)}},c9fe:function(t,e,o){},e267:function(t,e,o){"use strict";o.r(e);var i=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"esf bigbox"},[o("div",{},[o("el-breadcrumb",{staticClass:"navsbox",attrs:{"separator-class":"el-icon-arrow-right"}},[o("el-breadcrumb-item",{attrs:{to:{path:"/"}}},[t._v("首页")]),o("el-breadcrumb-item",[t._v("新闻管理")]),o("el-breadcrumb-item",[t._v("新闻列表")])],1)],1),o("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm flex",attrs:{model:t.ruleForm,"label-width":"120px"}},[o("el-form-item",{staticClass:"formlist",attrs:{label:"新闻标题",prop:"title"}},[o("el-input",{model:{value:t.ruleForm.title,callback:function(e){t.$set(t.ruleForm,"title",e)},expression:"ruleForm.title"}})],1),o("el-form-item",{staticClass:"formlist",attrs:{label:"新闻来源",prop:"m"}},[o("el-input",{model:{value:t.ruleForm.forms,callback:function(e){t.$set(t.ruleForm,"forms",e)},expression:"ruleForm.forms"}})],1),o("el-form-item",{staticClass:"formlist",attrs:{label:"新闻类型",prop:"wyyear"}},[o("el-select",{staticClass:"formlist",attrs:{placeholder:"请选择"},model:{value:t.ruleForm.values,callback:function(e){t.$set(t.ruleForm,"values",e)},expression:"ruleForm.values"}},t._l(t.optionyear,function(t){return o("el-option",{key:t.value,attrs:{label:t.label,value:t.value}})}),1)],1),o("el-form-item",{attrs:{label:"新闻展示图"}},[o("el-upload",{staticClass:"upload-demo",attrs:{action:this.$store.state.actionUrl,"on-preview":t.handlePreview,"on-remove":t.handleRemove,"file-list":t.fileList,"before-upload":t.upbefore,"on-success":t.upsuccess,limit:t.int,"list-type":"picture"}},[o("el-button",{attrs:{size:"small",type:"primary"}},[t._v("点击上传")]),o("span",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("*只能上传一张jpg/png文件，且不超过500kb")])],1)],1),o("el-form-item",{staticClass:"formlist",attrs:{label:"新闻内容",prop:"cont"}},[[o("div",{staticClass:"editor"},[o("div",{ref:"editor",model:{value:t.html,callback:function(e){t.html=e},expression:"html"}})])]],2)],1),o("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.updataNew()}}},[t._v("提交")])],1)},s=[],a=(o("ac6a"),o("1a0b")),l=o.n(a),r=[],n={name:"addNews",props:{editorContent:{type:String,default:""}},data:function(){return{html:null,int:1,uptoken:null,editorOption:{},imgArr:"",fileList:[],ruleForm:{title:"",forms:"",cont:"",values:"",seleqws:"1",years:"1"},optionyear:[{value:1,label:"行业风云"},{value:2,label:"找房攻略"}]}},methods:{updatanews:function(){var t=this;if(void 0==this.$route.query.id)return!1;this.$axios.post("journalism/selectByPrimaryKey.action",{id:this.$route.query.id}).then(function(e){t.html=e.data.data.content,t.ruleForm.values=e.data.data.genre,t.ruleForm.title=e.data.data.title,t.ruleForm.forms=e.data.data.source})},upbefore:function(t,e,o){},upsuccess:function(t,e,o){this.imgArr=o[0].response.data[0]},handleRemove:function(t,e){console.log(t,e)},handlePreview:function(t){console.log(t)},updataNew:function(){var t=this;this.$axios.post("journalism/insertSelective.action",{genre:this.ruleForm.values,title:this.ruleForm.title,jour_pic:this.imgArr,content:this.html,source:this.ruleForm.forms,result:r}).then(function(e){t.$message({message:e.data.msg,type:"success"}),setTimeout(function(){t.$router.push({path:"/Newsadmin/newslist"})},1e3)})},uploadInit:function(t){t.imgMenuId,t.toolbarElemId,t.textElemId}},mounted:function(){var t=this;window.sessionStorage.setItem("pathids",this.$route.fullPath),this.updatanews();var e=this.html,o=new l.a(this.$refs.editor);o.customConfig.onchange=function(e){t.html=o.txt.text()},o.customConfig.menus=["head","bold","fontSize","fontName","italic","underline","strikeThrough","foreColor","backColor","link","list","justify","quote","emoticon","image","table","video","code","undo","redo"],o.customConfig.fontNames=["宋体","微软雅黑","Arial","Tahoma","Verdana"],o.customConfig.uploadImgShowBase64=!1,o.customConfig.uploadFileName="file",o.customConfig.uploadImgServer="http://192.168.1.116:8080/journalism/uploading.action",o.customConfig.uploadImgHooks={before:function(t,e,o){},success:function(t,e,o){},fail:function(t,e,o){},error:function(t,e){},timeout:function(t,e){},customInsert:function(t,e,o){console.log(r),console.log(123);var i=e.data[0];t(i);r.push(e.data[0]),console.log(r)}},o.create(),o.txt.text(e),this.editorContent&&o.txt.text(this.editorContent),this.uploadInit(o)}},u=n,c=(o("3e94"),o("2877")),m=Object(c["a"])(u,i,s,!1,null,"7809cf27",null);e["default"]=m.exports}}]);