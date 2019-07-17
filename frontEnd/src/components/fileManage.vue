<template>
  <!-- 档案管理 -->
  <div class="fileManage">
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
          档案编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          档案编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          档案编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          档案编号：
          <el-input v-model="input" placeholder="请输入内容" size="mini"></el-input>
        </div>
        <div class="seachItem">
          档案编号：
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
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="id" label="员工编号"></el-table-column>
          <el-table-column prop="date" label="头像" width="100">
            <template slot-scope="scope">
              <div class="listAvatar" :style="{backgroundImage:'url(' + scope.row.image + ')'}"></div>
            </template>
          </el-table-column>
          <el-table-column prop="name" label="姓名"></el-table-column>
          <el-table-column prop="sex" label="性别"></el-table-column>
          <el-table-column prop="department" label="部门"></el-table-column>
          <el-table-column prop="duty" label="职务"></el-table-column>
          <el-table-column prop="now" label="人员状态"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope" style="oveflow:hidden">
              <div class="buttomDetail" @click="dialogTableVisible = true">详情</div>
              <div class="buttomDelete" @click="handleDelete(scope.$index, scope.row)">删除</div>
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
    <el-dialog title="员工1008611个人档案" :visible.sync="dialogTableVisible">
      <el-table :data="tableData">
        <el-table-column property="id" label="编号" width="150"></el-table-column>
        <el-table-column property="name" label="姓名" width="200"></el-table-column>
        <el-table-column property="duty" label="职位"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "fileManage",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      tableData: [
        {
          id: 1008611,
          date: "2016-05-02",
          image: "https://s2.ax1x.com/2019/07/16/ZHLt8U.jpg",
          name: "张三",
          sex: "男",
          department: "开发部",
          duty: "主管",
          now: "在职"
        },
        {
          id: 1008611,
          date: "2016-05-02",
          image: "https://s2.ax1x.com/2019/07/16/ZHLt8U.jpg",
          name: "张三",
          sex: "男",
          department: "开发部",
          duty: "主管",
          now: "在职"
        },
        {
          id: 1008611,
          date: "2016-05-02",
          image: "https://s2.ax1x.com/2019/07/16/ZHLt8U.jpg",
          name: "张三",
          sex: "男",
          department: "开发部",
          duty: "主管",
          now: "在职"
        },
        {
          id: 1008611,
          date: "2016-05-02",
          image: "https://s2.ax1x.com/2019/07/16/ZHLt8U.jpg",
          name: "张三",
          sex: "男",
          department: "开发部",
          duty: "主管",
          now: "在职"
        }
      ]
    };
  },
  methods: {
    handleDelete(index, row) {
      console.log(index, row);
    },
    // 分页切换
    handleCurrentChange(cpage) {
      this.currpage = cpage;
    }
  }
};
</script>

<style>
.fileManage {
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
  background-position: center;
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
</style>
