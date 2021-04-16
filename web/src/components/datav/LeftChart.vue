<template>
  <div class="left-chart-1">
    <div class="lc1-header">违法记录</div>
    <div class="lc-img">
      <img :src="crimeURL" id="img0">
      <img :src="crimeURL" id="img1">
      <img :src="crimeURL" id="img2">
      <img :src="crimeURL" id="img3">
      <img :src="crimeURL" id="img4">
      <img :src="crimeURL" id="img5">
      <img :src="crimeURL" id="img6">
      <img :src="crimeURL" id="img7">
      <img :src="crimeURL" id="img8">
    </div>
  </div>
</template>

<script>
export default {
  name: 'LeftChart1',
  data () {
    return {
      crimeURL: 'http://39.106.106.202/crime/demo.png'
    }
  }
}
</script>

<style lang="less">
.left-chart-1 {
  width: 100%;
  height: 37%;

  .lc1-header {
    text-align: center;
    height: 40px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    margin-bottom: 20px;
  }
  .lc-img{
    display: flex;
    flex-flow: row wrap;
    justify-content:space-around ;
    img {
      max-height: 30%;
      margin-bottom: 20px;
      max-width: 26%;
    }
  }
}
</style>
