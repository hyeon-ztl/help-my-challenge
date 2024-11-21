<template>
    <li @click="clickVideo" class="result-item">
        <img :src="video.snippet.thumbnails.default.url" class="result-item-img">
        <span class="result-item-title">{{ videoTitle }}</span>
    </li>
</template>

<script setup>
    import { ref, computed } from 'vue';
    import { useYoutubeStore } from '@/stores/youtube';
    import _ from 'lodash';

    const store = useYoutubeStore();

    const props = defineProps({
        video: Object
    });

    const videoTitle = computed(()=>{
       return _.unescape(props.video.snippet.title);
    });

    const clickVideo = function() {
        store.clickVideo(props.video);
    };
    
</script>

<style scoped>

</style>