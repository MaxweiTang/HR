<template>
  <div class="hrHeader">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>{{ pageName }}</el-breadcrumb-item>
      <div class="userMsgArea">
        <div class="userAvatar">
          <div class="img" :style="{backgroundImage:'url(' + userAvatar + ')'}"></div>
        </div>
        <el-button type="primary" icon="el-icon-switch-button" size="mini" @click="logOut"></el-button>
      </div>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  name: "hrHeader",
  components: {},
  data() {
    return {
      pageName: "",
      userAvatar: "https://s2.ax1x.com/2019/07/16/Z76h1U.jpg"
    };
  },
  methods: {
    logOut() {
      this.$router.push({ path: "/" });
    },
    routers() {
      console.log(this.$router);
    },
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name);
      const second = matched[1];
      this.pageName = second.name;
    }
  },
  watch: {
    $route() {
      this.getBreadcrumb();
    }
  },
  mounted() {
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
  width: 15%;
  height: 8vh;
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
}
.userAvatar > .img {
  position: relative;
  padding-top: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
}
</style>
