<template>
    <div class="align-result">
        <iframe class="video-box"
            :src="videoUrl" 
            title="YouTube video player" 
            frameborder="0" 
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" 
            referrerpolicy="strict-origin-when-cross-origin" 
            allowfullscreen>
        </iframe>
        <div>{{videoTitle}}</div>
        <div class="detail-box box-border-radius">
            <ReviewView />
        </div>
    </div>
</template>

<script setup>
    import { computed } from 'vue';
    import { useYoutubeStore } from '@/stores/youtube';
    import ReviewView from '@/views/ReviewView.vue';
    import _ from 'lodash';

    const store = useYoutubeStore();

    const videoUrl = computed(()=>{
        const videoSrc = store.video;
        // console.log(videoSrc);
        return `https://www.youtube.com/embed/${videoSrc}`;
    });

    
</script>

<style scoped>
.align-result {
    margin-top: 1.2rem;
    width: 100%;
    display:flex;
    flex-direction:column;
    align-items: center;
    
}

.detail-box {
    width: 100%;
    min-height: 100vh; /* 화면 끝까지 채우는 높이 */
    margin-inline: auto;

    padding-inline : 0.6rem;
    padding-top: 0.6rem;

    border-radius: 15px;
    background: #FFFFFF;

    display: flex;
    flex-direction:column;
    align-items: center;
}

.video-box{
    width:100%;
    aspect-ratio: 16 / 9; 
}
</style>