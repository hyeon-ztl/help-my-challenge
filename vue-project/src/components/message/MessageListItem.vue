<template>
    <div>
        <p>{{ props.day }} 일차 메시지</p>
        <div v-if="store.message === null && userStore.loginUser !== null">
            <button v-if="userStore.loginUser.email !== route.params.email">등록</button>
        </div>
    </div>
</template>

<script setup> 
    import { onMounted } from 'vue';
    import { useMessageStore } from '@/stores/message';
    import { useUserStore } from '@/stores/user';
    import { useRoute } from 'vue-router';

    const store = useMessageStore();
    const userStore = useUserStore();
    const route = useRoute();

    const props = defineProps({
        day: Number,
    });

    onMounted(()=>{ // 사용자의 해당 일차의 메시지 가져오기
        store.getMessage(userStore.loginUser.email, props.day);
    });

</script>

<style scoped>

</style>