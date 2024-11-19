<template>
    <div>
        <div v-if="store.goal">
            <p v-if="diff < 0">{{ store.goal.email }}님 운동 시작 {{ -diff }}일 전</p>
            <p v-if="diff > 0">{{ store.goal.email }}님 운동 시작 {{ diff }}일차</p>
            <div>
                <p>{{store.goal.goalName}} {{ store.goal.goalDescription }}</p>
                <p>{{ store.goal.startDate }} 시작</p>
            </div>
            <div>
                <p>challenge</p>
                <p>{{ store.goal.day }} 도전</p>
            </div>
            <div>
            <p>실패 공약</p>
            <p>{{ store.goal.pledge }}</p>
            </div>
            <div>
                <p>{{ store.goal.email }}의 한마디</p>
                <p>{{ store.goal.text }}</p>
                <p v-if="userStore.loginUser !== null">
                    <button @click="updateText" v-if="userStore.loginUser.email === route.params.email">수정</button>
                </p>
            </div>
        </div>
        <div v-if="!store.goal" @click="goalRegist">
            <div>
                <p>목표를 등록해주세요.</p>
            </div>
            <div>
                <p>challenge</p>
                <p>목표를 등록해주세요.</p>
            </div>
            <div>
                <p>실패 공약</p>
                <p>공약을 등록해주세요</p>
            </div>
            <div>
                <p>한마디</p>
                <p>한마디를 등록해주세요.</p>
            </div>
        </div>
    </div>
</template>

<script setup>
    import { onMounted, computed } from 'vue';
    import { useRoute, useRouter } from 'vue-router';
    import { useGoalStore } from '@/stores/goal';
    import { useUserStore } from '@/stores/user';

    const store = useGoalStore();
    const userStore = useUserStore();
    const router = useRouter();
    const route = useRoute();

    onMounted(()=>{
        console.log(route.params.email);
        store.getGoal(route.params.email);
    });

    const diff = computed(()=> {
        const today = new Date();
        const start = new Date(store.goal.startDate);

        const diffInMilliseconds = today-start;
        return Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24));
    });

    const goalRegist = function() {
        router.push({name: 'goalRegist'});
    };

    const updateText = function() {
        router.push({name: 'updateGoal'});
    };

</script>

<style scoped>

</style>