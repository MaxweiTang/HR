<template>
  <div class="hrAside">
    <el-menu
      default-active="1"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#606266"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <!-- <el-menu-item index="1" @click="gotoIndex">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item> -->
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-user"></i>
          <span>人员档案</span>
        </template>
        <el-menu-item index="2-1" @click="gotoFileManage">人员信息管理</el-menu-item>
        <el-menu-item index="2-2" @click="gotoFile2Manage">档案管理</el-menu-item>
        <el-menu-item index="2-3" @click="gotoContractManage">合同管理</el-menu-item>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-s-home"></i>
          <span>部门管理</span>
        </template>
        <el-menu-item index="3-1" @click="gotoTransfere">人事调配</el-menu-item>
        <el-menu-item index="3-2" @click="gotoAttendance">考勤管理</el-menu-item>
      </el-submenu>
      <el-menu-item index="3" @click="gotoTrainRecord">
        <i class="el-icon-reading"></i>
        <span slot="title">教育培训</span>
      </el-menu-item>
      <el-menu-item index="4" @click="gotoRecruit">
        <i class="el-icon-document"></i>
        <span slot="title">招聘记录</span>
      </el-menu-item>
      <el-menu-item index="5" @click="gotoPersonal">
        <i class="el-icon-setting"></i>
        <span slot="title">薪资数据</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "hrAside",
  components: {},
  data() {
    return {};
  },
  methods: {
    handleOpen(key, keyPath) {
      // console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      // console.log(key, keyPath);
    },
    gotoPersonal() {
      this.$router.push({ path: "/personal" });
    },
    gotoIndex() {
      this.$router.push({ path: "/index" });
    },
    gotoFileManage() {
      this.$router.push({ path: "/fileManage" });
    },
    gotoContractManage() {
      this.$router.push({ path: "/contractManage" });
    },
    gotoTransfere() {
      this.$router.push({ path: "/transfer" });
    },
    gotoAttendance() {
      this.$router.push({ path: "/attendance" });
    },
    gotoRecruit() {
      this.$router.push({ path: "/recruit" });
    },
    gotoTrainRecord() {
      this.$router.push({ path: "/trainingRecords" });
    },
    gotoFile2Manage() {
      this.$router.push({ path: "/file2Manage" });
    }
  }
};
</script>

<style>
.hrAside {
  width: 100%;
  height: 100%;
}
</style>
