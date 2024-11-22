<template>
  <div class="challenge-view-layout">
    <GoalView/>
    <MessageView/>
  </div>
</template>

<script setup>
  import GoalView from '@/components/goal/GoalView.vue';
  import MessageView from '@/components/message/MessageView.vue';

  import { useRoute } from 'vue-router';
  const route = useRoute();
</script>

<style scoped>
    .challenge-view-layout {
      margin-top: 2rem;
      width: 100%;
      border: 3px solid red;
      display: flex; 
      flex-direction: column;
      align-content: center;
    }
  
</style>