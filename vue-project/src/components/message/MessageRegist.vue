<template>
    <div>
        <fieldset>
            <div>
                <label for="senderNickname">from</label>
                <input type="text" id="senderNickname" v-model="message.senderNickname">
            </div>
            <div>
                <label for="content">내용</label>
                <input type="text" id="content" v-model="message.content">
            </div>
            <div>
                <select v-model="stickerId" id="stickerId">
                    <option value="1">스티커1</option>
                    <option value="2">스티커2</option>
                    <option value="3">스티커3</option>
                    <option value="4">스티커4</option>
                    <option value="5">스티커5</option>
                </select>
            </div>
            <div>
                <button @click="registMessage">등록</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
    import { ref } from 'vue';
    import { useRoute } from 'vue-router';
    import { useGoalStore } from '@/stores/goal';
    import { useUserStore } from '@/stores/user';
    import { useMessageStore } from '@/stores/message';

    const goalStore = useGoalStore();
    const userStore = useUserStore();
    const store = useMessageStore();
    const route = useRoute();

    const message = ref({
        receiver: goalStore.goal.email,
        sender: userStore.loginUser.email,
        senderNickname: '',
        goalId: goalStore.goal.goalId,
        content: '',
        day: route.params.day,
        stickerId: ''
    });

    const registMessage = function() {
        console.log(message.value);
        store.registMessage(message.value);
    }

</script>

<style scoped>

</style>