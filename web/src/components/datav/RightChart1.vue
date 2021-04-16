<template>
  <div class="right-chart-1">
    <div class="rc1-chart-container">
      <div class="left">
        <div class="rc1-header">人流量</div>
        <div class="number" id="total-person">{{total}}</div>
      </div>

      <dv-charts :option="option"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RightChart1',
  data () {
    return {
      option: {
        title: {
          text: '分时人流图',
          style: {
            fill: '#eee'
          }
        },
        xAxis: {
          data: this.$store.state.timeName,
          axisLabel: {
            style: {
              fill: '#eee',
              rotate: 20,
              textAlign: 'left',
              textBaseline: 'top'
            }
          },
          axisTick: {
            show: false
          }
        },
        yAxis: [
          {
            name: '人流量',
            data: 'value',
            min: 0,
            max: 100,
            interval: 10,
            splitLine: {
              style: {
                lineDash: [3, 3]
              }
            },
            axisLabel: {
              show: false,
              formatter: '{value}',
              style: {
                fill: '#eee'
              }
            },
            axisTick: {
              show: false
            }
          },
          {
            name: '违法人数',
            data: 'value',
            position: 'right',
            min: 0,
            max: 30,
            interval: 5,
            splitLine: {
              show: false
            },
            axisLabel: {
              formatter: '{value}',
              style: {
                fill: '#eee'
              }
            },
            axisTick: {
              show: false
            }
          }
        ],
        series: [
          {
            name: '人流量',
            style: {
              fill: '#eee'
            },
            data: this.$store.state.timeData,
            type: 'bar',
            gradient: {
              color: ['#37a2da', '#67e0e3']
            },
            animationCurve: 'easeOutBounce'
          },
          {
            name: '违法人数',
            data: this.$store.state.timeData,
            type: 'line',
            yAxisIndex: 1,
            animationCurve: 'easeOutBounce'
          }
        ]
      }
    }
  },
  computed: {
    total () {
      return parseInt(this.$store.state.total)
    }
  },
  watch: {
    '$store.state.timeName' () {
      this.option.xAxis.data = this.$store.state.timeName
      this.option.series[0].data = this.$store.state.timeData
      this.option.series[1].data = this.$store.state.timeData
    }
  }
}
</script>

<style lang="less">
.right-chart-1 {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;

  .rc1-header {
    font-size: 24px;
    font-weight: bold;
    height: 30px;
    line-height: 30px;
    margin-right: 3px;
    margin-bottom: 26px
  }

  .rc1-chart-container {
    flex: 1;
    display: flex;
  }

  .left {
    width: 30%;
    font-size: 16px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    .number {
      font-size: 34px;
      color: #096dd9;
      font-weight: bold;
      margin-bottom: 30px;
    }
  }

  .right {
    flex: 1;
    padding-bottom: 20px;
    padding-right: 20px;
    box-sizing: border-box;
  }
}
</style>
