<template>
  <div class="homePage">
    <el-container>
      <el-aside>
        <hrAside />
      </el-aside>
      <el-container>
        <el-header>
          <hrHeader />
        </el-header>
        <el-main>      
          <router-view />
          </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import hrAside from "@/components/hrAside.vue";
import hrHeader from "@/components/hrHeader.vue";
export default {
  name: "home",
  components: {},
  data() {
    return {};
  },
  methods: {},
  components: {
    hrAside,
    hrHeader,
  }
};
</script>

<style>
.homePage {
  width: 100%;
  height: 100%;
}
.el-header {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  height: 8vh !important;
  padding: 0 !important;
}

.el-aside {
  background-color: #606266;
  color: #333;
  text-align: center;
  
}
.el-container {
  width: 100%;
  height: 100%;
}
</style>
