<template>
  <!-- 招聘记录 -->
  <div class="recruit">
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
    </div>
    <div class="seachDataArea" v-loading="false">
      <div class="dataTitle">
        <div class="dataIconArear">
          <i class="el-icon-document">数据列表</i>
        </div>
      </div>
      <div class="dataLsitArea">
        <el-table :data="tableData" border style="width: 100%">
          <el-table-column prop="id" label="招聘编号"></el-table-column>
          <el-table-column prop="applyid" label="员工编号"></el-table-column>
          <el-table-column label="员工照片" width="100">
            <template slot-scope="scope">
              <div class="listAvatar" :style="{backgroundImage:'url(' + scope.row.avatar + ')'}"></div>
            </template>
          </el-table-column>
          <el-table-column prop="applyname" label="姓名"></el-table-column>
          <el-table-column prop="applytel" label="联系方式"></el-table-column>
          <el-table-column prop="degree" label="部门"></el-table-column>
          <el-table-column prop="duty" label="职位"></el-table-column>
          <el-table-column prop="entrytime" label="签约时间"></el-table-column>
          <el-table-column prop="now" label="状态"></el-table-column>
          <el-table-column prop="remark" label="备注"></el-table-column>
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
  </div>
</template>

<script>
export default {
  name: "recruit",
  components: {},
  data() {
    return {
      input: "",
      currpage: 1,
      dialogTableVisible: false,
      transferVisble: false,
      timeDate: "",
      tableData: [
        {
          id: 1000,
          applyid: 1008611,
          applyname: "张三",
          applytel: "13300000021",
          avatar: "http://jiaowu.sicau.edu.cn/photo/201603993.jpg",
          degree: "本科",
          department: "开发",
          duty: "主管",
          entrytime: "2019-07-15",
          applystate:"签约完成",
          now: "在职",
          remark: ""
        }
      ],
      // 部门/职位
      value: [],
      options: [
        {
          label: "开发",
          value: "开发",
          children: [
            {
              label: "主管",
              value: "主管"
            },
            {
              label: "职员",
              value: "职员"
            }
          ]
        },
        {
          label: "营销",
          value: "主管",
          children: [
            {
              label: "主管",
              value: "主管"
            },
            {
              label: "职员",
              value: "职员"
            }
          ]
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
    }
  }
};
</script>

<style scoped>
.recruit {
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
</style>
