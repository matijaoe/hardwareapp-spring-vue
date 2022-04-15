<script setup lang="ts">
import { useThemeVars } from "naive-ui";
import { PhInfo } from "phosphor-vue";

type Props = {
  price: number;
};

const vars = useThemeVars();
console.log("vars :>> ", vars.value);

const props = defineProps<Props>();

const message = computed(() => {
  let msg = "";
  if (props.price < 200) {
    msg = "Ovaj hardver se ne može kupiti na rate.";
  } else if (props.price < 500) {
    msg = "Ovaj hardver se može kupiti na 6 rata.";
  } else if (props.price < 900) {
    msg = "Ovaj hardver se može kupiti na 12 rata.";
  } else {
    msg = "Ovaj hardver se može kupiti na 24 rate.";
  }
  return msg;
});
</script>

<template>
  <n-alert title="Obročna uplata" type="info" h="full">
    <template #icon>
      <n-icon>
        <PhInfo :color="vars.infoColor" weight="fill" />
      </n-icon>
    </template>
    {{ message }}
  </n-alert>
</template>

<style lang="scss" scoped></style>
