<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
  let vm = new Vue({
    el: '#app',
    mixins: [mixin],
    methods: {
      formatDate(date, fmt) {// 时间格式化
        let o = {
          'M+': date.getMonth() + 1, // 月份
          'd+': date.getDate(), // 日
          'h+': date.getHours(), // 小时
          'm+': date.getMinutes(), // 分
          's+': date.getSeconds(), // 秒
          'S': date.getMilliseconds() // 毫秒
        }
        if (/(y+)/.test(fmt)) {
          fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
        }
        for (var k in o) {
          if (new RegExp('(' + k + ')').test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (('00' + o[k]).substr(('' + o[k]).length)))
          }
        }
        return fmt
      }
    },
    getHrefParam(key) { /*获取地址栏参数*/
      let s = window.location.href;
      let reg = new RegExp(key + "=\\w+");
      let rs = reg.exec(s);
      if (rs === null || rs === undefined) {
        return "";
      } else {
        return rs[0].split("=")[1];
      }
    },
  })
</script>
</body>
</html>
