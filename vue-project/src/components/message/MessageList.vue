<template>
    <div>
        <MessageListItem v-for="day in Array.from({ length: store.goal.day })" :key="day"/>
    </div>
</template>

<script setup>
    import { useGoalStore } from '@/stores/goal';
    import MessageListItem from './MessageListItem.vue';

    const store = useGoalStore();
</script>

<style scoped>
</style>
