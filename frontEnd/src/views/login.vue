<template>
  <div class="homePage">
    <div class="homePicArea">
      <div class="shelter">
        <div class="shelterComtent">
          <div class="shelterTitle">For You</div>
          <div class="shelterContent">为您私人定制的管理系统</div>
        </div>
      </div>
      <div class="img" id="imgs"></div>
    </div>
    <div class="loginArea">
      <div class="login">
        <div class="title">管理员登陆</div>
        <el-form ref="form" :model="form" label-width="80px">
          <el-input v-model="form.name" placeholder="用户名"></el-input>
          <el-input v-model="form.password" placeholder="密码"></el-input>
          <div class="verCodeArae">
            <el-input v-model="form.verCode" placeholder="验证码" class="verCode"></el-input>
            <div class="imgArea">
              <div class="img" :style="{backgroundImage:'url(' + mainAreaImgUrl + ')'}"></div>
            </div>
          </div>
          <el-button @click="onSubmit">登陆</el-button>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import * as mChange from "matrixchange";
import { setInterval } from "timers";
export default {
  name: "login",
  components: {},
  data() {
    return {
      form: {
        name: "",
        password: "",
        verCode: "",
        interval: ''
      },
      mainAreaImgUrl: "https://s2.ax1x.com/2019/07/15/ZTFX5j.jpg"
    };
  },
  methods: {
    onSubmit() {
      console.log(this.form);
      clearInterval(this.interval); 
      this.$router.push({ path: "/home" });
    }
  },
  mounted() {
    var app = document.getElementById("imgs");
    var urls = [
      "https://s2.ax1x.com/2019/07/15/ZTFX5j.jpg",
      "https://s2.ax1x.com/2019/07/16/Z72Y79.jpg",
      "https://s2.ax1x.com/2019/07/16/Z72J0J.png"
    ];
    // 该方法返回一个对象
    var move = mChange.makeMatrixChange(app, {
      images: urls,
      row: 10,
      col: 10
    });
    this.interval  = setInterval(function() {
      move.movePoint(mChange.mode[1]);
    }, 5000);
  }
};
</script>

<style>
html {
  height: 100%;
  width: 100%;
}
body {
  height: 100%;
  width: 100%;
}
.homePage {
  width: 100%;
  height: 100%;
}
.homePicArea {
  overflow: hidden;
  float: left;
  width: 60%;
  height: 100%;
  position: relative;
}
.loginArea {
  float: right;
  width: 40%;
  height: 100%;
  background-color: #fff;
  display: flex;
  align-items: center;
  position: relative;
}
.login {
  width: 60%;
  height: 60%;
  margin: 0 auto;
}
.title {
  height: 6vh;
  line-height: 6vh;
  font-size: 1.5vw;
  font-weight: bold;
  margin-bottom: 2vh;
}
.el-input {
  width: 80% !important;
  height: 3vh;
  margin-bottom: 5vh;
}
.login > .el-form > button {
  width: 80%;
}
.verCodeArae {
  width: 80%;
  height: 6vh;
  /* position: absolute; */
  margin-bottom: 2vh;
}
.verCode {
  width: 30% !important;
}
.imgArea {
  width: 40%;
  float: right;
  background-color: #fff;
  height: 5vh;
  overflow: hidden;
}
.img {
  position: relative;
  padding-top: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
.shelter {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.3);
  z-index: 999;
}
.shelterComtent {
  width: 80%;
  height: 10vh;
  margin: 0 auto;
  margin-top: 30vh;
}
.shelterTitle {
  width: 100%;
  font-size: 6vh;
  color: #d9d9d9;
  font-weight: 500;
  margin-bottom: 2vh;
}
.shelterContent {
  width: 100%;
  font-size: 2vh;
  font-weight: 400;
  color: #d9d9d9;
}
</style>
