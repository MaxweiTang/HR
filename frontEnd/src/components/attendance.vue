<template>
  <!-- 考勤管理 -->
  <div class="attendance">
    <div class="seachArea">
      <div class="iconArear">
        <i class="el-icon-search">筛选搜索</i>
      </div>
      <div class="buttomArea">
        <el-button type="info" plain size="mini">重置</el-button>
        <el-button type="info" plain size="mini">搜索</el-button>
      </div>
      <div class="conditionArea">
        <div class="seachItem">
          时间：
          <el-date-picker v-model="timeDate" type="date" placeholder="选择日期"></el-date-picker>
        </div>
        <div class="seachItem">
          考勤编号：
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
      </div>
    </div>
    <div class="seachDataArea" v-loading.lock="loadingFlag">
      <div class="dataTitle">
        <div class="dataIconArear">
          <i class="el-icon-document">数据列表</i>
        </div>
        <div class="addButtom" @click="showAddDialog">添加</div>
      </div>
      <div class="dataLsitArea">
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="staff_id" label="员工编号"></el-table-column>
          <el-table-column width="100" label="员工照片">
            <template slot-scope="scope">
              <div
                class="listAvatar"
                :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + scope.row.avatar + '.jpg)'}"
              ></div>
            </template>
          </el-table-column>
          <el-table-column prop="name" label="姓名"></el-table-column>
          <el-table-column prop="time" label="时间"></el-table-column>
          <el-table-column prop="status" label="考勤情况"></el-table-column>
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
    <el-dialog title="考勤管理" :visible.sync="dialogTableVisible">
      <div style="overflow: hidden">
        <div class="transBlock">
          <span class="demonstration">员工Id:</span>
          <el-input v-model="attendan.staff_id" placeholder="员工Id"></el-input>
        </div>
        <div class="transBlock">
          <span class="demonstration">选择日期</span>
          <el-date-picker
            v-model="attendan.time"
            type="date"
            placeholder="选择日期"
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd"
          ></el-date-picker>
        </div>
        <div class="transBlock">
          <span class="demonstration">状态：</span>
          <el-cascader v-model="attendan.status" :options="options"></el-cascader>
        </div>
      </div>
      <div style="overflow: hidden">
        <div class="buttomOk" @click="saveContract(attendan)">保存</div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "attendance",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      transferVisble: false,
      timeDate: "",
      tableData: [],
      token: "",
      loadingFlag: true,
      attendan: {
        staff_id: "",
        time: "",
        status: ""
      },
      options: [
        {
          label: "迟到",
          value: "迟到"
        },
        {
          label: "旷班",
          value: "旷班"
        },
        {
          label: "请假",
          value: "请假"
        },
        {
          label: "出差",
          value: "出差"
        },
        {
          label: "停职",
          value: "停职"
        },
        {
          label: "事假",
          value: "事假"
        }
      ]
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
    getAllAttendMsg() {
      this.$axios({
        method: "POST",
        url: "/attendant/list",
        data: { staff_id: "" },
        headers: {
          token: this.token
        }
      }).then(response => {
        console.log(response);
        var resData = response.data;
        if (resData.code == 0) {
          this.tableData = resData.data.reverse();
          this.loadingFlag = false;
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
        }
      });
    },
    showAddDialog() {
      this.dialogTableVisible = true;
    },
    saveContract(item) {
      console.log(item);
      var attendan = this.attendan;
      this.$axios({
        method: "post",
        url: "/staff/attendant",
        data: {
          staff_id: attendan.staff_id,
          time: attendan.time,
          status: attendan.status[0]
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        console.log(resData);
        if (resData.code == 0) {
          this.getAllAttendMsg();
          this.$message({
            message: "修改成功",
            type: "success"
          });
        } else {
          this.$message({
            showClose: true,
            message: resData.msg,
            type: "error"
          });
        }
      });
    }
  },
  mounted() {
    this.token = this.$store.getters.getUserToken;
    this.getAllAttendMsg();
  }
};
</script>

<style scoped>
.attendance {
  width: 100%;
  height: 100%;
}
.seachArea {
  width: 100%;
  height: 20vh;
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
  height: 8vh;
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
.transBlock {
  float: left;
  width: 40%;
  margin: 1vh 2vw;
}
.demonstration {
  margin-right: 1vw;
}
</style>
