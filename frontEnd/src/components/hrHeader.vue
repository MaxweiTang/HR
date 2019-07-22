<template>
  <div class="hrHeader">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>{{ pageName }}</el-breadcrumb-item>
      <div class="userMsgArea">
        <div class="userTitle" v-if="identity">欢迎您 超级管理员</div>
        <div class="userTitle" v-if="!identity">欢迎您 普通用户</div>
        <div class="userAvatar">
          <div class="img" :style="{backgroundImage:'url(' + userAvatar + ')'}"></div>
        </div>
        <el-button type="primary" size="mini" @click="showPassward">修改密码</el-button>
        <el-button type="primary" icon="el-icon-switch-button" size="mini" @click="logOut"></el-button>
      </div>
    </el-breadcrumb>
    <el-dialog title="修改密码" :visible.sync="dialogTableVisible" width="20%">
      <div class="transBlock">
        <span class="demonstration">新密码:</span>
        <el-input v-model="password" placeholder="请输入新密码" show-password>></el-input>
      </div>
      <div style="overflow: hidden;">
        <div class="buttomOk" @click="saveContract()">保存</div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "hrHeader",
  components: {},
  data() {
    return {
      pageName: "",
      userAvatar: "https://s2.ax1x.com/2019/07/16/Z76h1U.jpg",
      dialogTableVisible: false,
      password: "",
      identity: ''
    };
  },
  methods: {
    logOut() {
      this.$axios({
        method: "get",
        url: "/safety/logout",
        headers: {
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        console.log(response);
        if (resData.code == 0) {
          this.$message({
            message: "成功登出",
            type: "success"
          });
          this.$router.push({ path: "/" });
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
          this.$router.push({ path: "/" });
        }
      });
    },
    routers() {
      console.log(this.$router);
    },
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name);
      const second = matched[1];
      this.pageName = second.name;
    },
    showPassward() {
      this.dialogTableVisible = true;
    },
    saveContract() {
      if (!this.password) {
        this.$message({
          showClose: true,
          message: "密码不能空",
          type: "error"
        });
        return false;
      }
      var password = this.password;
      this.$axios({
        method: "post",
        url: "/safety/newpassword",
        data: {
          newpasswd: password
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          this.$message({
            message: "修改成功",
            type: "success"
          });
          this.dialogTableVisible = false;
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
          this.$router.push({ path: "/" });
        }
      });
    }
  },
  watch: {
    $route() {
      this.getBreadcrumb();
    }
  },
  mounted() {
    this.token = this.$store.getters.getUserToken;
    var identity = this.$store.getters.getIdentity;
    if (identity) {
      this.identity = true;
    } else {
      this.identity = false;
    }
    this.getBreadcrumb();
  }
};
</script>

<style>
.hrHeader {
  width: 100%;
  height: 100%;
  background-color: #d3dce6;
}
.el-breadcrumb {
  padding: 0 2vw !important;
  line-height: 8vh !important;
  font-size: 14px !important;
}
.userMsgArea {
  float: right;
  height: 8vh;
  display: flex;
  align-items: center;
  overflow: hidden;
}
.userMsgArea > button {
  color: #fff !important;
  background-color: #606266 !important;
  border: none !important;
}
.userAvatar {
  float: left;
  width: 6vh;
  height: 6vh;
  margin: 1vh 0;
  border-radius: 50%;
  overflow: hidden;
  margin: 0 2vw;
}
.userAvatar > .img {
  position: relative;
  padding-top: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
.buttomOk {
  box-sizing: border-box;
  float: right;
  text-align: center;
  width: 5vw;
  font-size: 1vw;
  color: #fff;
  background-color: #606266;
  font-weight: bold;
  padding: 1vh;
  border-radius: 2vw;
  margin: 1vh 2vw;
}
.buttomOk:hover {
  box-sizing: border-box;
  background-color: #fff;
  color: #606266;
  border: 1px solid #606266;
  cursor: pointer;
}
.transBlock {
  width: 95%;
  margin: 1vh auto;
}
.demonstration {
  float: left;
  margin: 0.5vw 0;
}
.userTitle {
  height: 5vh;
  line-height: 5vh;
  background-color: #606266;
  padding: 0 1vw;
  border-radius: 1vw;
  font-size: 1vw;
  font-weight: bold;
  color: #fff;
}
</style>
