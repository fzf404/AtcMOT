<template>
  <div class='center-cmp'>
    <div v-if="tflag">
      <div v-for="(value,key) in personData" :key="key">
        <button class="draw-person" v-bind:style="{ top: 146+(value[1]/1080*400)+'px', left: 378+(value[0]/1840*680)+'px', width: value[2]/1920*680+'px', height: value[3]/1080*390+'px'}">{{key}}</button>
      </div>
    </div>
    <template v-if="!isShowMultiple && show">
      <vue-aliplayer-v2 :source="source" ref="VueAliplayerV2" :options="options" />
    </template>
  </div>
</template>

<script>
import VueAliplayerV2 from 'vue-aliplayer-v2'

export default {
  name: 'CenterCmp',
  components: {
    VueAliplayerV2
  },
  data () {
    return {
      options: {
        isLive: true,
        format: 'm3u8',
        height: '200%'
      },
      source: '',
      show: true,
      isShowMultiple: false,
      // personLabel: this.$store.state.personLabel,
      // personPos: this.$store.state.personPos
      personData: this.$store.state.personData
    }
  },
  computed: {
    tflag () {
      return this.$store.state.tflag
    }
  },
  watch: {
    '$store.state.rtmpURL' () {
      this.source = this.$store.state.rtmpURL
    },
    '$store.state.personData' () {
      // this.personLabel = this.$store.state.personLabel
      // this.personPos = this.$store.state.personPos
      this.personData = this.$store.state.personData
    }
  }
}

</script>

<style lang='less'>
.draw-person {

  position:fixed;

  border: 0px;
  outline: 3px solid rgb(19, 19, 165);

  background: rgba(0,0,0,0);
  color: #eee;

  z-index: 9999;
}

.center-cmp {
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 3px;
  display: flex;
  flex-direction: column;
}
</style>
