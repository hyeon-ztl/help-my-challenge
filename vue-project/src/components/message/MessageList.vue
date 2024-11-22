<template>
    <div class="day-container">
      <div v-if="store.goal">
        <!-- 빈칸 추가 -->
        <div v-for="blank in Array.from({ length: startDay }, () => null)" :key="blank" class="day-item blank"></div>
        
        <!-- 실제 MessageListItem 렌더링 -->
        <MessageListItem 
          v-for="day in Array.from({ length: store.goal.day }, (_, i) => i)" 
          :key="day" 
          :day="day" 
          class="day-item"
        />
      </div>
    </div>
  </template>
  
  
  <script setup>
  import { useGoalStore } from '@/stores/goal';
  import MessageListItem from './MessageListItem.vue';
  import { onMounted } from 'vue';
  import { useRoute } from 'vue-router';

  const store = useGoalStore();
  const route = useRoute();

  onMounted(()=>{
    store.getGoal(route.params.email);
  });

  console.log(store.goal);

  const startDay = 6; // 요일 받아올 곳
  </script>
  
  <style scoped>

  
  </style>
  