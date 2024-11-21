<template>
    <div id="modal-user-input">
        <label for="name" class="modal-alarm">이름</label> 
        <input type="text" id="name" v-model="store.goal.name" class="modal-input">
        <label for="startDate" class="modal-alarm">시작 일자</label> 
        <input type="text" id="startDate" v-model="tempStartDate" class="modal-input">
        <label for="endDate" class="modal-alarm">종료 일자</label>
        <input type="text" id="endDate" v-model="store.goal.endDate" class="modal-input">
        <label for="goalCode" class="modal-alarm">목표 설정</label>
        <select name="goalCode" id="goalCode" v-model="store.goal.goalCode" class="modal-input">
            <option value="100">체중</option>
            <option value="200">체지방</option>
            <option value="300">골격근</option>
            <option value="400">BMI</option>
            <option value="500" selected="selected">기타</option>
        </select>
        <label for="goalDescription" class="modal-alarm">목표 수치</label>
        <input type="text" id="goalDescription" v-model="store.goal.goalDescription" class="modal-input">
        <label for="pledge" class="modal-alarm">실패 공약</label>
        <input type="text" id="pledge" v-model="store.goal.pledge" class="modal-input">
        <button @click="updateGoal" class="modal-regist-btn">수정</button>
    </div>
</template>

<script setup>
    import { ref, onMounted } from 'vue';
    import { useRoute }  from 'vue-router';
    import { useGoalStore } from '@/stores/goal';

    const store = useGoalStore();
    const route = useRoute();

    onMounted(()=>{
        store.getGoal(route.params.email);
    });

    const tempStartDate = ref(store.goal.startDate);

    const updateGoal = function() {
        if(tempStartDate !== store.goal.startDate) {
            store.goal.startDate = tempStartDate;
        }
        store.updateGoal();
    };

</script>

<style scoped>

</style>