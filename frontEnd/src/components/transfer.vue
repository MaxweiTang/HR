<template>
  <!-- 人事调配 -->
  <div class="transfer">
    <el-tabs type="border-card">
      <el-tab-pane label="调动记录">
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
              调动编号：
              <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </div>
            <div class="seachItem">
              员工编号：
              <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </div>
            <div class="seachItem">
              调动时间：
              <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </div>
          </div>
        </div>
        <div class="seachDataArea" v-loading.lock="loadingFlag">
          <div class="dataTitle">
            <div class="dataIconArear">
              <i class="el-icon-document">数据列表</i>
            </div>
          </div>
          <div class="dataLsitArea">
            <el-table :data="tableData" border style="width: 100%">
              <el-table-column prop="staff_id" label="员工编号"></el-table-column>
              <el-table-column label="员工照片" width="100">
                <template slot-scope="scope">
                  <div
                    class="listAvatar"
                    :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + scope.row.avatar + '.jpg)'}"
                  ></div>
                </template>
              </el-table-column>
              <el-table-column prop="name" label="姓名"></el-table-column>
              <el-table-column prop="from" label="原职务"></el-table-column>
              <el-table-column prop="to" label="新职务"></el-table-column>
              <el-table-column prop="time" label="调动时间"></el-table-column>
              <el-table-column prop="reason" label="原因"></el-table-column>
              <!-- <el-table-column label="操作">
                <template slot-scope="scope" style="oveflow:hidden">
                  <div class="buttomDelete" @click="handleDeleteDdata(scope.$index, scope.row)">删除</div>
                </template>
              </el-table-column>-->
            </el-table>
          </div>
          <div class="bottomArea">
            <el-pagination
              background
              layout="prev, pager, next, total, jumper"
              :total="tableData.length"
              @current-change="handleCurrentChange"
            ></el-pagination>
          </div>
        </div>
      </el-tab-pane>
      <el-tab-pane label="调动操作">
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
              员工编号：
              <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </div>
            <div class="seachItem">
              员工姓名
              <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </div>
            <div class="seachItem">
              部门职务
              <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
            </div>
          </div>
        </div>
        <div class="seachDataArea" v-loading="false">
          <div class="dataTitle">
            <div class="dataIconArear">
              <i class="el-icon-document">数据列表</i>
            </div>
          </div>
          <div class="dataLsitArea">
            <el-table :data="tableData1" border style="width: 100%">
              <el-table-column prop="id" label="员工编号"></el-table-column>
              <el-table-column label="头像" width="100">
                <template slot-scope="scope">
                  <div
                    class="listAvatar"
                    :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + scope.row.avatar + '.jpg)'}"
                  ></div>
                </template>
              </el-table-column>
              <el-table-column prop="name" label="姓名"></el-table-column>
              <el-table-column prop="sex" label="性别"></el-table-column>
              <el-table-column prop="department" label="部门"></el-table-column>
              <el-table-column prop="position" label="职务"></el-table-column>
              <el-table-column label="操作">
                <template slot-scope="scope" style="oveflow:hidden">
                  <div class="buttomDetail" @click="handleDetail(scope.$index, scope.row)">详情</div>
                  <div class="buttomDelete" @click="handleDelete(scope.$index, scope.row)">调动</div>
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
      </el-tab-pane>
    </el-tabs>

    <el-dialog :title="personalInfo.name + '个人档案'" :visible.sync="dialogTableVisible" width="80%">
      <table width="100%" class="infoTable" v-loading.lock="detailLoading">
        <tr>
          <td class="personAvatar" rowspan="2">
            <div
              class="listAvatar"
              :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + personalInfo.people_id + '.jpg)'}"
            ></div>
          </td>
          <td>员工编号：{{ personalInfo.people_id }}</td>
          <td>姓名： {{ personalInfo.name }}</td>
          <td>性别：{{ personalInfo.sex }}</td>
          <td>
            部门：
            <el-input v-model="personalInfo.department" placeholder="部门" :disabled="true"></el-input>
          </td>
          <td>
            职务：
            <el-input v-model="personalInfo.position" placeholder="职务" :disabled="true"></el-input>
          </td>
        </tr>
        <tr>
          <td>出生日期：{{ personalInfoHide.birth }}</td>
          <td colspan="2">电话号码：{{ personalInfoHide.tel }}</td>
          <td>学历：{{ personalInfoHide.degree }}</td>
          <td colspan="2">入职时间：{{ personalInfoHide.register_date }}</td>
        </tr>
        <tr>
          <td colspan="2" style="height: 7vh;">邮箱地址：{{ personalInfoHide.email }}</td>
          <td colspan="5">备注：{{ personalInfoHide.remark }}</td>
        </tr>
      </table>
    </el-dialog>
    <el-dialog
      :title="translInfo.name + '职务调动'"
      :visible.sync="transferVisble"
      v-loading="loadingTransMsg"
      element-loading-text="修改中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.8)"
    >
      <table width="100%" class="infoTable">
        <tr>
          <td class="personAvatar" rowspan="2">
            <div
              class="listAvatar"
              :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + translInfo.people_id + '.jpg)'}"
            ></div>
          </td>
          <td>员工编号：{{ translInfo.id }}</td>
          <td>姓名： {{ translInfo.name }}</td>
          <td>现部门：{{ translInfo.department }}</td>
          <td>现职务：{{ translInfo.position }}</td>
        </tr>
      </table>
      <div class="transMsg">*注：线上职务调动仅限部门内调动</div>
      <div class="buttomArea1">
        <div class="transBlock">
          <span class="demonstration">调动至：</span>
          <el-cascader v-model="value" :options="options"></el-cascader>
        </div>
        <div class="transBlock">
          <span class="demonstration">申请时间：</span>
          <el-input v-model="dataTime" placeholder="格式：2019-07-20"></el-input>
        </div>
        <div class="transBlock">
          <span class="demonstration" style="oveflow:left;">调用原因：</span>
          <el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="textarea"></el-input>
        </div>
        <div class="buttomOk" @click="handleTransfer(translInfo.id)">保存</div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "transfer",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      transferVisble: false,
      detailLoading: true,
      // 调动记录
      tableData: [],
      personalInfo: "",
      translInfo: "",
      loadingFlag: true,
      loadingTransMsg: false,
      // 用户职位列表
      tableData1: [],
      // 调动信息
      value: [],
      personalInfo: {},
      personalInfoHide: {},
      textarea: "",
      dataTime: "",
      options: [
        {
          label: "主管",
          value: "主管"
        },
        {
          label: "职员",
          value: "职员"
        },
        {
          label: "打工仔",
          value: "打工仔"
        }
      ]
    };
  },
  methods: {
    handleDelete(index, row) {
      console.log(index, row);
      this.translInfo = row;
      this.transferVisble = true;
    },
    handleDetail(index, row) {
      var people_id = row.people_id;
      this.personalInfo = row;
      this.dialogTableVisible = true;
      this.$axios({
        method: "post",
        url: "people/list",
        data: { people_id: people_id },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          this.personalInfoHide = resData.data[0];
          this.detailLoading = false;
        } else {
          this.$message({
            showClose: true,
            message: "服务器错误，请稍后重试",
            type: "error"
          });
        }
      });
    },
    // 分页切换
    handleCurrentChange(cpage) {
      this.currpage = cpage;
    },
    handleDeleteDdata(index, row) {
      console.log(index, row);
    },
    // 获取职位调配记录
    getPosition_log() {
      this.$axios({
        method: "post",
        url: "/position_log/list",
        data: { staff_id: "" },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          this.tableData = resData.data;
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
    getAllUserMsg() {
      this.$axios({
        method: "post",
        url: "/staff/list",
        data: { staff_id: "" },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        if (resData.code == 0) {
          this.tableData1 = resData.data;
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
    // 调整职位
    handleTransfer(id) {
      this.loadingTransMsg = true;
      var staff_id = id;
      var time = this.dataTime;
      var reason = this.textarea;
      var to = this.value[0];
      this.$axios({
        method: "post",
        url: "staff/transfer",
        data: {
          staff_id: staff_id,
          to: to,
          time: time,
          reason: reason
        },
        headers: {
          "Content-Type": "application/json",
          token: this.token
        }
      }).then(response => {
        var resData = response.data;
        console.log(resData);
        if (resData.code == 0) {
          this.getAllUserMsg();
          this.getPosition_log();
          this.loadingTransMsg = false;
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
    this.getPosition_log();
    this.getAllUserMsg();
  }
};
</script>

<style scoped>
.transfer {
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
  height: 5vh;
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
}
.dataIconArear {
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
.transMsg {
  width: 40%;
  margin: 2vh 0;
  font-size: 0.8vw;
  color: red;
}
.buttomArea1 {
  width: 100%;
  overflow: hidden;
}
.transBlock {
  float: left;
  width: 40%;
  margin: 1vh 2vw;
}
.demonstration {
  margin-right: 1vw;
}
.buttomOk {
  float: left;
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
  background-color: #fff;
  color: #606266;
  border: 1px solid #606266;
  cursor: pointer;
}
.el-input {
  width: 65%;
}
.el-textarea {
  width: 65%;
}
</style>
