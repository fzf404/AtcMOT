<template>
  <div class="bottom-charts">
    <div class="bc-chart-item">
      <div class="bcci-header">路口1</div>
      <!-- <template v-if="!isShowMultiple && show">
        <vue-aliplayer-v2 :source="source1" ref="VueAliplayerV2" :options="options" />
      </template> -->
    </div>
    <dv-decoration-2 class="decoration-1" :reverse="true" style="width:5px;" />

    <div class="bc-chart-item">
      <div class="bcci-header">路口2</div>
      <!-- <template v-if="!isShowMultiple && show">
        <vue-aliplayer-v2 :source="source2" ref="VueAliplayerV2" :options="options" />
      </template> -->
    </div>

    <dv-decoration-2 class="decoration-2" :reverse="true" style="width:5px;" />

    <div class="bc-chart-item">
      <div class="bcci-header">路口3</div>
      <!-- <template v-if="!isShowMultiple && show">
        <vue-aliplayer-v2 :source="source3" ref="VueAliplayerV2" :options="options" />
      </template> -->

    </div>

    <dv-decoration-2 class="decoration-3" :reverse="true" style="width:5px;" />

    <div class="bc-chart-item">
      <div class="bcci-header">路口4</div>
      <!-- <template v-if="!isShowMultiple && show">
        <vue-aliplayer-v2 :source="source4" ref="VueAliplayerV2" :options="options" />
      </template> -->

    </div>

  </div>
</template>

<script>

export default {
  name: 'BottomCharts',
  components: {
  },
  data () {
    return {
      options: {
        isLive: true,
        format: 'm3u8',
        height: '70%'
      },
      source1: 'http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8',
      source2: 'http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8',
      source3: 'http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8',
      source4: 'http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8',
      show: true,
      isShowMultiple: false
    }
  }
}
</script>

<style lang="less">
.bottom-charts {
  width: 100%;
  height: 100%;
  display: flex;
  position: relative;

  .bc-chart-item {
    width: 25%;
    height: 100%;
    padding-top: 12px;
    box-sizing: border-box;
  }

  .bcci-header {
    height: 40px;
    text-align: center;
    line-height: 30px;
    font-size: 20px;
  }

  .dv-active-ring-chart {
    height: calc(~"100% - 80px");
  }

  .label-tag {
    height: 30px;
  }

  .active-ring-name {
    font-size: 18px !important;
  }

  .decoration-1, .decoration-2, .decoration-3 {
    display: absolute;
    left: 0%;
  }
}
</style>
