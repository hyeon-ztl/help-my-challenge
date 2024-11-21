<template>
    <div id="modal-user-input">
        <p class="modal-alarm">한마디를 적어주세요!</p>
        <textarea type="text" v-model="store.goal.text" class="modal-textarea"></textarea>
        <button @click="updateText" class="modal-regist-btn">저장</button>
    </div>
</template>

<script setup>
    import { onMounted } from 'vue';
    import { useRoute } from 'vue-router';
    import { useGoalStore } from '@/stores/goal';

    const store = useGoalStore();
    const route = useRoute();

    onMounted(()=>{
        store.getGoal(route.params.email);
    });

    const updateText = function() {
        store.updateGoal();
    };

</script>

<style lang="scss" scoped>

</style>