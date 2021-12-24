package com.msb.persistence.ekyc.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EkycLiveness")
public class EkycOcrLivenessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "idFontImage")
    private String idFrontImage;
    @Column(name = "idBackImage")
    private String idBackImage;
    @Column(name = "idFaceImage")
    private String idFaceImage;
    @Column(name = "idFaceUpImage")
    private String idFaceUpImage;
    @Column(name = "idFaceLeftImage")
    private String idFaceLeftImage;
    @Column(name = "idFaceRightImage")
    private String idFaceRightImage;
    @Column(name = "idFaceVideo")
    private String idFaceVideo;

    @ManyToOne
    @JoinColumn(name = "ekycProfileId" , nullable = false)
    private EkycProfileEntity ekycProfile;

}
