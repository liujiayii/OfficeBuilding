<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>

<div id="app">
  <div style="height:40px;width:100%;background: #ccc"></div>
  <div class="container">
    <ul class="search-term">
      <li class="cont">
        <div class="title">位置</div>
        <ul class="term">
          <li class="active">不限</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
          <li>长安</li>
        </ul>
      </li>
      <li class="cont">
        <div class="title">面积</div>
        <ul class="term">
          <li class="active">不限</li>
          <li>0-100</li>
          <li>100-200</li>
          <li>200-300</li>
          <li>300-400</li>
        </ul>
      </li>
      <li class="cont">
        <div class="title">单价</div>
        <ul class="term">
          <li class="active">不限</li>
          <li>3元以下</li>
          <li>3-4元</li>
          <li>4-5元</li>
          <li>5-7元</li>
        </ul>
      </li>
      <li class="cont">
        <div class="title">装修</div>
        <ul class="term">
          <li class="active">不限</li>
          <li>豪装</li>
          <li>精装</li>
          <li>简装</li>
          <li>毛坯</li>
        </ul>
      </li>
      <li class="cont">
        <div class="title"></div>
        <ul class="select term">
          <li>裕华区 x</li>
          <li>100-300 x</li>
        </ul>
      </li>
    </ul>
    <div class="house-list-main">
      <ul class="house-list">
        <template v-for="(item,index) in 10">
          <li class="house-cont">
            <div class="img"><img src="http://www.yunquekeji.com/assets/image/index/banner.png" alt=""></div>
            <div class="info">
              <div class="title">城乡林肯荣京国融力宝兴盛国锐好景易居两居</div>
              <div class="position"><img src="/static/images/position.png" height="15" width="12"/><span
                      style="margin: 0 20px 0 4px">长安 - 北二环</span>[ 138m² - 精装修 ]
              </div>
              <div class="person">近期有{{item*index}}人预约</div>
            </div>
            <div class="price"><span class="num">{{item}}</span>元/m²/天</div>
          </li>
        </template>
      </ul>
      <div class="aside">
        <div class="aside-cont">
          <div class="bg">
            <div class="title">
              <img src="/static/images/position-find.png" height="20" width="15"/>
              <span>地图找房</span>
            </div>
          </div>
          <div class="count">石家庄<span class="num">1526</span>套</div>
        </div>
        <div class="aside-cont">
          <div class="title">
            <img src="/static/images/bag.png" height="15" width="15"/>
            <span>委托找房</span>
          </div>
          <div class="img"><img src="/static/images/person.png" alt=""></div>
          <div class="info">10分钟快速响应，已有2015256人提交申请</div>
          <div class="btn">立即委托</div>
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  const mixin = {}
</script>
<%@ include file="./footer.jsp"%>
