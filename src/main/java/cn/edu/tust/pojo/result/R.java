package cn.edu.tust.pojo.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回的结果集<p>
 *
 * @author GSsun <br>
 * @date 2023/9/9 17:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  R<T> {
    /**
     * 状态编码 0 - error，1 - success
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String msg;
    /**
     * 数据体
     */
    private T data;

    public static<T> R<T> success(T data){
        return new R<>(1, null, data);
    }
    public static R success(){
        return R.builder().code(1).build();
    }
    public static R error(String msg){
        return R.builder().code(0).msg(msg).build();
    }
}
