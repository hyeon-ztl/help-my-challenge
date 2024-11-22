<template>
    <div class="day-container">
      <!-- 빈칸 추가 -->
      <div v-for="blank in Array.from({ length: startDay }, () => null)" :key="'blank-' + blank" class="day-item blank"></div>
      
      <!-- 실제 MessageListItem 렌더링 -->
      <MessageListItem 
        v-for="day in Array.from({ length: store.goal.day }, (_, i) => i)" 
        :key="'day-' + day" 
        :day="day" 
        class="day-item"
      />
    </div>
  </template>
  
  
  <script setup>
  import { useGoalStore } from '@/stores/goal';
  import MessageListItem from './MessageListItem.vue';

  const store = useGoalStore();
  const startDay = 6;
  </script>
  
  <style scoped>

    .day-container {
    display: grid;
    grid-template-columns: repeat(7, 1fr); /* 7열 고정 */
    gap: 10px; /* 각 칸 사이 간격 */
    }

    .day-item {
    border: 1px solid blue;
    height: 100px; /* 각 칸 높이 */
    display: flex;
    align-items: center;
    justify-content: center;
    }

    .day-item.blank {
    background-color: transparent; /* 빈칸은 투명 */
    }

    .day-item.filled {
    background-color: #f0f8ff;
    border: 1px solid #ddd;
    }
  
  </style>
  