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
                <!-- <select v-model="message.stickerId" id="stickerId">
                    <option value="1">스티커1</option>
                    <option value="2">스티커2</option>
                    <option value="3">스티커3</option>
                    <option value="4">스티커4</option>
                </select> -->
                <img src="/src/assets/sticker/sticker1.png" @click="message.stickerId = 1">
                <img src="/src/assets/sticker/sticker2.png" @click="message.stickerId = 2">
                <img src="/src/assets/sticker/sticker3.png" @click="message.stickerId = 3">
                <img src="/src/assets/sticker/sticker4.png" @click="message.stickerId = 4">
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

    const props = defineProps({
        day: Number,
    });

    const message = ref({
        receiver: route.params.email,
        sender: userStore.loginUser.email,
        senderNickname: '',
        goalId: goalStore.goal.goalId,
        content: '',
        day: props.day,
        stickerId: ''
    });

    const registMessage = function() {
        console.log(message.value);
        store.registMessage(message.value);
    }

</script>

<style scoped>

</style>