<template>
    <div>
      <h2>검색</h2>
      <input type="text" v-model.trim="store.keyword" @keyup.enter="search" />
      <button @click="search">검색</button>
      <hr>
      <YoutubeSearchResult/>
    </div>
  </template>
  
  <script setup>
  import { useYoutubeStore } from '@/stores/youtube';
  import YoutubeSearchResult from './YoutubeSearchResult.vue';
  import { onMounted } from 'vue';
  
  // Pinia Store 가져오기
  const store = useYoutubeStore();
  
  // 검색 함수
  const search = function () {
    store.youtubeSearch(store.keyword);
  };
  
  </script>
  
  <style scoped>
  /* 스타일 작성 */
  </style>
  