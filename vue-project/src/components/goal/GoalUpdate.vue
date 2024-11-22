<template>
    <div id="modal-user-input">
        <label for="name" class="modal-alarm">이름</label> 
        <input type="text" id="name" v-model="store.goal.name" class="modal-input">

        <label for="startDate" class="modal-alarm">시작 일자</label> 
        <Datepicker 
            v-model="tempStartDate" 
            :format="dateFormat" 
            :locale="customLocale"
            :week-starts-on="0"
            class="modal-input"
            :placeholder="store.goal.startDate"
        />

        <label for="endDate" class="modal-alarm">종료 일자</label>
        <Datepicker 
            v-model="tempEndDate" 
            :format="dateFormat"
            :locale="customLocale"
            :week-starts-on="0" 

            class="modal-input"
            :placeholder="store.goal.endDate"
        />
        <p>{{ errorMessage }}</p>

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
    import Datepicker from 'vue3-datepicker';
    import { ko } from 'date-fns/locale';

    const store = useGoalStore();
    const route = useRoute();

    const tempStartDate = ref(null);
    const tempEndDate = ref(null);
    onMounted(()=>{
        store.getGoal(route.params.email);
    });

    // DatePicker 관련 메서드
    // 원하는 날짜 형식
    const dateFormat = 'yyyy-MM-dd'; 

    // customLocale 설정
    const customLocale = {
        ...ko,
        options: {
            ...ko.options,
        },
    };

    // 날짜 포맷팅 함수
    const formatDate = (date) => {
        if (!date) return '';
        const d = new Date(date);
        const year = d.getFullYear();
        const month = String(d.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1
        const day = String(d.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    };

    // 일차수 계산 함수
    const calculateDays = (startDate, endDate) => {
        const start = new Date(startDate);
        const end = new Date(endDate);

        const diffInMilliseconds = end - start + 1;

        // 밀리초를 일수로 변환
        return Math.ceil(diffInMilliseconds / (1000 * 60 * 60 * 24)); // 올림 처리
    };

    const errorMessage = ref('');
    const updateGoal = function() {
        if(tempStartDate.value !== null) {
            tempStartDate.value = formatDate(tempStartDate.value);
            if(tempStartDate.value !== store.goal.startDate) {
                store.goal.startDate = tempStartDate.value;
            }
        }

        if(tempEndDate.value !== null) {
            tempEndDate.value = formatDate(tempEndDate.value);
            if(tempEndDate.value !== store.goal.EndDate) {
                if(new Date(store.goal.startDate) > new Date(tempEndDate.value)) {
                    errorMessage.value = '종료일은 시작일 이후여야 합니다!';
                    tempEndDate.value = null;
                    return;
                } else {
                    store.goal.endDate = tempEndDate.value;
                }
            }
        } 

        store.goal.day = calculateDays(store.goal.startDate, store.goal.endDate);

        store.updateGoal();
    };

</script>

<style scoped>

</style>
