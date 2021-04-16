<template>

  <div class="right-chart-2">
    <div class="btn-group">
        <button :class="classBtn1" style="color:rgba(255,255,255,0.5)" @click="setTrack">
            跟踪
        </button>
        <dv-decoration-2 class="decoration-01" :reverse="true" style="width:5px;height:150px;" />
        <button :class="classBtn2" style="color:rgba(255,100,100,0.4)" @click="setLight">
           红灯
        </button>
        <dv-decoration-2 class="decoration-01" :reverse="true" style="width:5px;height:150px;" />
        <button :class="classBtn3" style="color:rgba(100,255,100,0.4)" @click="setLight">
          绿灯
        </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RightChart2',
  data () {
    return {
      classBtn1: { btn: true, 'light-1': true },
      classBtn2: { btn: true, 'light-2': false },
      classBtn3: { btn: true, 'light-3': true }
    }
  },
  methods: {
    setTrack () {
      this.classBtn1['light-1'] = !this.classBtn1['light-1']
      this.$store.state.tflag = this.classBtn1['light-1']
    },
    setLight () {
      this.classBtn2['light-2'] = !this.classBtn2['light-2']
      this.classBtn3['light-3'] = !this.classBtn3['light-3']
      this.$store.state.rflag = this.classBtn2['light-2']
    }
  }
}
</script>

<style lang="less">

.btn-group{
    display: flex;
    margin-left: 20px;
    margin-top: 20px;
}
.decoration-01{
  display: flex;
}
.btn{
    margin:10px;
    background-color: rgba(22, 43, 90, 0.4);
    width: 90px;
    height: 130px;
    border: 0px;
    font-size: 20px;
    border-radius: 5px;
    outline: none;
}

.light-1 {
    background-color: rgba(22, 43, 90, 0.3);
    box-shadow: 0px 0px 8px 6px rgba(41, 87, 255, 0.4);
    color:rgba(255,255,255) !important;
}
.light-2 {
    background-color: rgba(22, 43, 90, 0.3);
    box-shadow: 0px 0px 8px 6px rgba(255, 41, 41, 0.6);
    color:rgb(255, 0, 0) !important;
}
.light-3 {
    background-color: rgba(22, 43, 90, 0.3);
    box-shadow: 0px 0px 8px 6px rgba(41, 255, 87, 0.4);
    color:rgba(100,255,100) !important;
}

</style>
