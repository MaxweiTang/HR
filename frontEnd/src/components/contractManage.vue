<template>
  <!-- 合同管理 -->
  <div class="contractManage">
    <div class="seachArea1">
      <div class="iconArear">
        <i class="el-icon-search">筛选搜索</i>
      </div>
      <div class="buttomArea">
        <el-button type="info" plain size="mini">重置</el-button>
        <el-button type="info" plain size="mini">搜索</el-button>
      </div>
      <div class="conditionArea">
        <div class="seachItem">
          合同编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          员工编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          部门：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          职务：
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
          <el-table-column label="头像" width="100">
            <template slot-scope="scope">
              <div
                class="listAvatar"
                :style="{backgroundImage:'url(http://jiaowu.sicau.edu.cn/photo/' + scope.row.avatar + '.jpg)'}"
              ></div>
            </template>
          </el-table-column>
          <el-table-column prop="name" label="姓名"></el-table-column>
          <el-table-column prop="department" label="部门"></el-table-column>
          <el-table-column prop="postion" label="职务"></el-table-column>
          <el-table-column prop="start" label="合同开始时间"></el-table-column>
          <el-table-column prop="end" label="合同结束时间"></el-table-column>
          <el-table-column prop="content" label="合同内容">
            <template slot-scope="scope" style="oveflow:hidden">
              <div class="buttomDetail" @click="handleDetail(scope.$index, scope.row)">详情</div>
            </template>
          </el-table-column>
          <el-table-column prop="conremark" label="备注"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope" style="oveflow:hidden">
              <div class="buttomDelete" @click="handleDelete(scope.$index, scope.row)">删除</div>
            </template>
          </el-table-column>
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

    <el-dialog title="合同详情" :visible.sync="dialogTableVisible">
      <div class="contentArea">{{ itemContent }}</div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "contractManage",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      itemContent: "",
      tableData: [],
      loadingFlag: true
    };
  },
  methods: {
    handleDelete(index, row) {
      console.log(index, row);
    },
    handleDetail(index, row) {
      this.dialogTableVisible = true;
      this.itemContent = row.content;
    },
    // 分页切换
    handleCurrentChange(cpage) {
      this.currpage = cpage;
    },
    getAllContract() {
      this.$axios({
        method: "post",
        url: "/contract/list",
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
            message: "服务器错误，请稍后重试",
            type: "error"
          });
        }
      });
    }
  },
  mounted() {
    this.token = this.$store.getters.getUserToken;
    this.getAllContract();
  }
};
</script>

<style>
.contractManage {
  width: 100%;
  height: 100%;
}
.seachArea1 {
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
.contentArea {
  padding: 1vw;
}
</style>
