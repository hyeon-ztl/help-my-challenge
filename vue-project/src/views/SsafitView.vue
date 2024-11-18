<template>
    <div>
        <YoutubeSearch/>

        <router-view/>
    </div>
</template>

<script setup>
    import YoutubeSearch from '@/components/youtube/YoutubeSearch.vue';
    import { useYoutubeStore } from '@/stores/youtube';

    
</script>

<style scoped>

</style>