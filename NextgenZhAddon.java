package dev.nextgen.zh;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;

import java.lang.reflect.Field;
import java.util.Map;

/** Only visible labels are localized. Never change module/setting IDs used by configs and commands. */
public final class NextgenZhAddon extends MeteorAddon {
    private static final Map<String, String> WORDS = Map.ofEntries(
        Map.entry("Combat", "战斗"), Map.entry("Movement", "移动"), Map.entry("Render", "渲染"),
        Map.entry("Player", "玩家"), Map.entry("World", "世界"), Map.entry("Misc", "杂项"),
        Map.entry("General", "常规"), Map.entry("Scale", "缩放"), Map.entry("Background", "背景"),
        Map.entry("Inventory", "背包预览"), Map.entry("Armor", "护甲"), Map.entry("Radar", "雷达"),
        Map.entry("Auto Totem", "自动图腾"), Map.entry("Auto Crystal", "自动水晶"),
        Map.entry("Kill Aura", "杀戮光环"), Map.entry("Crystal Aura", "水晶光环"),
        Map.entry("Surround", "自动围绕"), Map.entry("Anchor Aura", "重生锚攻击"),
        Map.entry("Auto Armor", "自动穿甲"), Map.entry("Auto Eat", "自动进食"),
        Map.entry("Auto Tool", "自动工具"), Map.entry("Auto Mine", "自动挖掘"),
        Map.entry("Speed", "速度"), Map.entry("Flight", "飞行"), Map.entry("Fly", "飞行"),
        Map.entry("No Fall", "无摔落伤害"), Map.entry("Step", "自动上台阶"),
        Map.entry("Sprint", "自动疾跑"), Map.entry("Jesus", "水上行走"),
        Map.entry("Fullbright", "全亮"), Map.entry("Full Bright", "全亮"),
        Map.entry("ESP", "透视标记"), Map.entry("Tracers", "追踪线"),
        Map.entry("Storage ESP", "容器透视"), Map.entry("Name Tags", "名称标签"),
        Map.entry("Nametags", "名称标签"), Map.entry("Freecam", "自由视角"),
        Map.entry("Xray", "矿物透视"), Map.entry("X Ray", "矿物透视"),
        Map.entry("No Render", "隐藏渲染"), Map.entry("HUD", "界面显示"),
        Map.entry("Active Modules", "启用模块"), Map.entry("FPS", "帧率"),
        Map.entry("Ping", "延迟"), Map.entry("Watermark", "水印"),
        Map.entry("Enabled", "启用"), Map.entry("Mode", "模式"),
        Map.entry("Range", "范围"), Map.entry("Delay", "延迟"),
        Map.entry("Priority", "优先级"), Map.entry("Color", "颜色"),
        Map.entry("Background Color", "背景颜色"), Map.entry("Custom Scale", "自定义缩放"),
        Map.entry("Containers", "容器内容"), Map.entry("Rotate", "旋转"),
        Map.entry("Rotation", "旋转"), Map.entry("Target", "目标"),
        Map.entry("Targets", "目标"), Map.entry("Players", "玩家"),
        Map.entry("Mobs", "生物"), Map.entry("Animals", "动物"),
        Map.entry("Distance", "距离"), Map.entry("Size", "大小"),
        Map.entry("Width", "宽度"), Map.entry("Height", "高度"),
        Map.entry("Opacity", "不透明度"), Map.entry("Transparency", "透明度"),
        Map.entry("Outline", "轮廓"), Map.entry("Flat", "纯色"),
        Map.entry("Texture", "纹理"), Map.entry("None", "无"),
        Map.entry("Friends", "好友"), Map.entry("Macros", "宏"),
        Map.entry("Profiles", "配置档案"), Map.entry("Config", "配置"),
        Map.entry("GUI", "界面"), Map.entry("Settings", "设置")
    );

    @Override public String getPackage() { return "dev.nextgen.zh"; }

    @Override public void onInitialize() {
        int translated = 0;
        for (Module module : Modules.get().getAll()) {
            translated += translate(module, "title", module.title);
            for (SettingGroup group : module.settings) {
                translated += translate(group, "name", group.name);
                for (Setting<?> setting : group) {
                    translated += translate(setting, "title", setting.title);
                }
            }
        }
        System.out.println("[Nextgen ZH] Translated " + translated + " labels. Internal IDs unchanged.");
    }

    private static int translate(Object target, String fieldName, String original) {
        String translation = WORDS.get(original);
        if (translation == null) return 0;
        try {
            Field field = target.getClass().getField(fieldName);
            field.setAccessible(true);
            field.set(target, translation);
            return 1;
        } catch (ReflectiveOperationException | RuntimeException ex) {
            System.err.println("[Nextgen ZH] Cannot translate " + original + ": " + ex);
            return 0;
        }
    }
}
