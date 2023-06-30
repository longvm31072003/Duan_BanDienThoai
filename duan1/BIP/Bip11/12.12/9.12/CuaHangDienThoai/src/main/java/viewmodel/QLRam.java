/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lethi
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QLRam {
    private UUID idRam;
    private String ma;
    private String ten;
    private int trangThai;
}
