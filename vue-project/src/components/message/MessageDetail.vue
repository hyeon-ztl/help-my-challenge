<template>
    <div>
        messageDetail
        {{ store.message.senderNickname }}
    </div>
</template>

<script setup>
    import { onMounted, watch } from 'vue';
    import { useRoute } from 'vue-router';

    import { useMessageStore } from '@/stores/message';
    
    const route = useRoute();
    const store = useMessageStore();

    watch(() => store.message, (newMessage) => {
        if (newMessage) {
            console.log('Message updated:', newMessage);
        }
    }
);

</script>

<style scoped>

</style>