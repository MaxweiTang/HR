<template>
  <!-- 培训记录 -->
  <div class="trainingRecords">
    <!-- <div class="seachArea">
      <div class="iconArear">
        <i class="el-icon-search">筛选搜索</i>
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
        <div class="addButtom" @click="showAddDialog" v-show="identity">添加</div>
      </div>
      <div class="dataLsitArea">
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column label="员工照片" width="100">
            <template slot-scope="scope">
              <div
                class="listAvatar"
                :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + scope.row.avatar + '.jpg)'}"
              ></div>
            </template>
          </el-table-column>
          <el-table-column prop="staff_id" label="员工编号"></el-table-column>
          <el-table-column prop="name" label="姓名"></el-table-column>
          <el-table-column prop="sex" label="性别"></el-table-column>
          <el-table-column prop="program" label="培训科目"></el-table-column>
          <el-table-column prop="result" label="培训成绩"></el-table-column>
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
    <el-dialog title="添加培训记录" :visible.sync="dialogTableVisible" width="40%">
      <div style="overflow: hidden;width:60%;margin: 0 auto;">
        <div class="transBlock">
          <span class="demonstration">员工Id:</span>
          <el-input v-model="attendan.staff_id" placeholder="员工Id"></el-input>
        </div>
        <div class="transBlock">
          <span class="demonstration">选择日期：</span>
          <el-date-picker
            v-model="attendan.time"
            type="date"
            placeholder="选择日期"
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
          ></el-date-picker>
        </div>
        <div class="transBlock">
          <span class="demonstration">项目：</span>
          <el-select v-model="attendan.program_id" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.name"
              :value="item.id"
            ></el-option>
          </el-select>
        </div>
        <div class="transBlock">
          <span class="demonstration">评价:</span>
          <el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="attendan.result"></el-input>
        </div>
        <div class="buttomOk" @click="handleTransfer">保存</div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "trainingRecords",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      transferVisble: false,
      timeDate: "",
      tableData: [],
      // 部门/职位
      value: [],
      options: [],
      attendan: {
        staff_id: "",
        program_id: "",
        time: "",
        result: ""
      },
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
    getAllTrainList() {
      this.$axios({
        method: "post",
        url: "/train/list",
        data: {
          staff_id: ""
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          console.log(resData.data);
          this.tableData = resData.data;
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
    showAddDialog() {
      this.dialogTableVisible = true;
    },
    getAllProgram() {
      this.$axios({
        method: "get",
        url: "/program/list",
        data: {
          staff_id: ""
        },
        headers: {
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          this.options = resData.data;
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
    handleTransfer() {
      var attendan = this.attendan;
      this.$axios({
        method: "post",
        url: "/staff/train",
        data: {
          staff_id: attendan.staff_id,
          program_id: attendan.program_id,
          time: attendan.time,
          result: attendan.result
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          this.getAllTrainList();
          this.$message({
            message: "添加成功",
            type: "success"
          });
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
    this.getAllTrainList();
    this.getAllProgram();
  }
};
</script>

<style scoped>
.trainingRecords {
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
