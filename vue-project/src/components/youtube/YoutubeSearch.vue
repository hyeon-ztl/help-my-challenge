<template>
    <div class="search-layout" :class = "{'search-layout-main': isMainSearch, 'search-layout-video': !isMainSearch }">
      <input type="text" v-model.trim="keyword" @keyup.enter="search" class="search-input" placeholder="Search"/>
      <button @click="search" class="search-btn">검색</button>
    </div>
  </template>
  
  <script setup>
    import { computed } from 'vue';
    import { ref } from 'vue';
    import { useRouter, useRoute } from 'vue-router';
  
    const router = useRouter();
    const route = useRoute(); 
    
    const keyword = ref('');

    const search = function () {
      router.push({name: 'searchResult', params:{keyword: keyword.value}});
    };

    // 쿼리스트링에 검색어가 있는지 확인
    const isMainSearch = computed(() => route.path.startsWith('/'));
  
  </script>
  
  <style scoped>
 

  </style>
  