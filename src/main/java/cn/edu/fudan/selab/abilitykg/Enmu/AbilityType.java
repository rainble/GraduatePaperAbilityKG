package cn.edu.fudan.selab.abilitykg.Enmu;


public enum AbilityType {

    /**
     * 从XX运送到YY
     */
    TRANSPORT,
    /**
     * 提供XX（XX为物理资源）
     */
    PROVIDE,
    /**
     * 加工过程，如加热等
     */
    PROCESS,
    /**
     * 单纯的执行，如电动窗帘等
     */
    EXECUTE,
    /**
     * 感知环境，如传感器等
     */
    PERCEPTION,

    DISPLAY,

    LOADING,

    INTERACT,

    COMPUTE,

    STORAGE;

}
