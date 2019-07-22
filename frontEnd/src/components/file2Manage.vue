<template>
  <!-- 档案管理 -->
  <div class="file2Manage">
    <!-- <div class="seachArea">
      <div class="iconArear">
        <i class="el-icon-search">档案管理</i>
      </div>
      <div class="buttomArea">
        <el-button type="info" plain size="mini">重置</el-button>
        <el-button type="info" plain size="mini">搜索</el-button>
      </div>
      <div class="conditionArea">
        <div class="seachItem">
          招聘编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          员工编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          员工姓名：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          部门/职位：
          <el-cascader v-model="value" :options="options"></el-cascader>
        </div>
        <div class="seachItem">
          招聘状态：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
      </div>
    </div>-->
    <div class="seachDataArea" v-loading="false">
      <div class="dataTitle">
        <div class="dataIconArear">
          <i class="el-icon-document">数据列表</i>
        </div>
        <!-- <div class="addButtom" @click="showAddDialog">添加</div> -->
      </div>
      <div class="dataLsitArea">
        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop="staff_id" label="编号"></el-table-column>
          <el-table-column label="头像" width="100">
            <template slot-scope="scope">
              <div
                class="listAvatar"
                :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + scope.row.avatar + '.jpg)'}"
              ></div>
            </template>
          </el-table-column>
          <el-table-column prop="name" label="档案名称"></el-table-column>
          <el-table-column prop="sex" label="性别"></el-table-column>
          <el-table-column prop="remark" label="备注"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <div class="buttomDetail" @click="handleDetail(scope.$index, scope.row)">详情</div>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="bottomArea">
        <el-pagination
          background
          layout="prev, pager, next, total, jumper"
          :total="5"
          @current-change="handleCurrentChange"
        ></el-pagination>
      </div>
    </div>
    <el-dialog :title="personalInfo.name" :visible.sync="dialogTableVisible" width="80%">
      <table width="100%" class="infoTable">
        <tr>
          <td class="personAvatar" rowspan="2">
            <div
              class="listAvatar"
              :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + personalInfo.avatar + '.jpg)'}"
            ></div>
          </td>
          <td>性别：{{ personalInfo.sex }}</td>
          <td>
            档案内容：
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入内容"
              v-model="personalInfo.content"
              :disabled="!identity"
            ></el-input>
          </td>
          <td>
            备注：
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入内容"
              v-model="personalInfo.remark"
              :disabled="!identity"
            ></el-input>
          </td>
        </tr>
      </table>
      <div style="overflow: hidden;">
        <div class="buttomOk" @click="saveContract()" v-show="identity">保存</div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "file2Manage",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      timeDate: "",
      tableData: [],
      personalInfo: "",
      attendan: {
        name: "",
        time: "",
        birth: "",
        tel: "",
        degree: "",
        sex: "",
        email: ""
      },
      attendan1: {
        people_id: "",
        department_id: "",
        time: "",
        position: "",
        end: "",
        contarct_content: "",
        profile_name: "",
        profile_abstract: "",
        profiel_remark: ""
      },
      token: "",
      item: "",
      identity: ""
    };
  },
  methods: {
    // 分页切换
    handleCurrentChange(cpage) {
      this.currpage = cpage;
    },
    handleDeleteDdata(index, row) {
      console.log(index, row);
    },
    handleDetail(index, row) {
      this.personalInfo = row;
      this.dialogTableVisible = true;
    },
    handleTransfer() {
      var attendan = this.attendan;
      this.$axios({
        method: "post",
        url: "/people/new",
        data: {
          name: attendan.name,
          time: attendan.time,
          birth: attendan.birth,
          tel: attendan.tel,
          degree: attendan.degree,
          sex: attendan.sex,
          email: attendan.email
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        console.log(resData);
        if (resData.code == 0) {
          this.getAllUlist();
          this.$message({
            message: "添加成功",
            type: "success"
          });
          this.dialogTableVisible = false;
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
          if (resData.msg == "登录信息失效，请重新登录") {
            this.$router.push({ path: "/" });
          }
        }
      });
    },
    // 获取所有档案
    getAllUlist() {
      this.$axios({
        method: "post",
        url: "/profile/list",
        headers: {
          token: this.token
        },
        data: {
          staff_id: ""
        }
      }).then(response => {
        var resData = response.data;
        console.log(resData);
        if (resData.code == 0) {
          this.tableData = resData.data;
          this.loadingFlag = false;
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
          if (resData.msg == "登录信息失效，请重新登录") {
            this.$router.push({ path: "/" });
          }
        }
      });
    },
    saveContract() {
      var personalInfo = this.personalInfo;
      this.$axios({
        method: "post",
        url: "/staff/profile ",
        data: {
          staff_id: personalInfo.staff_id,
          remark: personalInfo.remark,
          content: personalInfo.content
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        console.log(response);
        var resData = response.data;
        if (resData.code == 0) {
          this.getAllUlist();
          this.$message({
            message: "添加成功",
            type: "success"
          });
          this.dialogTableVisible = false;
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
          if (resData.msg == "登录信息失效，请重新登录") {
            this.$router.push({ path: "/" });
          }
        }
      });
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
    this.getAllUlist();
  }
};
</script>

<style scoped>
.file2Manage {
  width: 100%;
  height: 100%;
}
.seachArea {
  width: 100%;
  height: 25vh;
  box-sizing: border-box;
  border: 1px solid #dcdfe6;
  position: relative;
}
.iconArear {
  height: 6vh;
  position: absolute;
  top: 0;
  left: 0;
}
.iconArear > i {
  font-size: 1vw;
  line-height: 6vh;
}
.el-icon-edit {
  line-height: 6vh;
}
.el-icon-search:before {
  margin: 0 0.5vw;
  font-size: 1.5vw;
  line-height: 6vh;
}
.buttomArea {
  margin-right: 2vw;
  height: 6vh;
  position: absolute;
  right: 0;
  top: 0;
  display: flex;
  align-items: center;
}
.conditionArea {
  height: 19vh;
  width: 100%;
  position: absolute;
  top: 6vh;
  overflow: hidden;
}
.seachItem {
  float: left;
  margin: 1vw;
  width: 20%;
  background-color: #fff;
  font-size: 1vw;
}
.fileManage > .el-input.el-input--mini {
  margin: 1vh 0 !important;
}
.seachDataArea {
  margin-top: 1vh;
  border: 1px solid #dcdfe6;
  box-sizing: border-box;
  width: 100%;
  position: relative;
  overflow: hidden;
}
.dataTitle {
  width: 100%;
  height: 5vh;
  line-height: 5vh;
  margin: 1vh 0;
  overflow: hidden;
}
.dataIconArear {
  float: left;
  width: 60%;
  margin-left: 0.5vw;
  height: 100%;
}
.dataLsitArea {
  width: 95%;
  margin: 1vh auto;
}
.listAvatar {
  position: relative;
  padding-top: 100%;
  background-size: cover;
  background-repeat: no-repeat;
  /* background-position: center; */
}
.bottomArea {
  margin: 1vh 1.5vw;
  float: right;
}
.buttomDelete,
.buttomDetail {
  float: left;
  box-sizing: border-box;
  text-align: center;
  line-height: 3.5vh;
  color: #606266;
  border-radius: 10%;
  width: 2.5vw;
  height: 3.5vh;
  font-size: 0.8vw;
  background-color: #fff;
  border: 1px solid #c1c1c2;
}
.buttomDelete {
  margin-left: 0.5vw;
  background-color: rgba(252, 71, 71, 0.822);
  color: #fff;
  border: none;
}
.buttomDetail:hover {
  background-color: #606266;
  border: none;
  color: #fff;
}
.personAvatar {
  width: 6vw;
  height: 8vw;
}
.infoTable > tr > td {
  border: 1px solid #000;
}
.el-input.is-disabled .el-input__inner {
  color: #606266 !important;
}
.infoTable > tr > td > .el-input {
  margin-bottom: 0 !important;
  height: 100%;
}
.transBlock {
  width: 95%;
  margin: 1vh auto;
}
.demonstration {
  margin-right: 1vw;
}
.seachItem > input {
  height: 100%;
}
.addButtom {
  float: right;
  /* padding: 1vh; */
  height: 4vh;
  line-height: 4vh;
  padding: 0 1vh;
  font-size: 0.8vw;
  background-color: rgba(252, 71, 71, 0.822);
  color: #fff;
  margin-right: 2vw;
  border-radius: 10%;
}
.addButtom:hover {
  color: #606266;
  background-color: #dcdfe6;
  cursor: pointer;
}
.demonstration {
  float: left;
  margin: 0.5vw 0;
}
</style>
