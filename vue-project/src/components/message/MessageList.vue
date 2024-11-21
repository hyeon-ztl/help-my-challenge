<template>
    <div v-if="store.goal">
        
        <MessageListItem v-for="day in Array.from({ length: store.goal.day+1 }, (_, i) => i)" :key="day" :day="day"/>
    </div>
</template>

<script setup>
    import { useGoalStore } from '@/stores/goal';
    import MessageListItem from './MessageListItem.vue';

    const store = useGoalStore();
</script>

<style scoped>
</style>
