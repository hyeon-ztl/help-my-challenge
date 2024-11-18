<template>
    <div>
        <YoutubeSearchResultItem v-for="video in store.videoList" :key="video.id.videoId" :video="video"/>
    </div>
</template>

<script setup>
    import { ref } from 'vue';
    import { useYoutubeStore } from '@/stores/youtube';
    import YoutubeSearchResultItem from './YoutubeSearchResultItem.vue';

    const store = useYoutubeStore();

</script>

<style scoped>

</style>