package com.bill99.base.account.deal.domain.vo;

import java.util.Date;

import com.google.common.base.MoreObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode
public class MemberInfoVo {
	private Long id;
    private Long memberCode;
    private Integer memberType;
    private String memberName;
    private Integer memberStatus;
    private String mobile;
    private String email;
    private Integer serviceLevel;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private Date crtTime;
    private Date updTime;
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("memberCode", memberCode)
                .add("memberType", memberType)
                .add("memberName", memberName)
                .add("memberStatus", memberStatus)
                .add("mobile", mobile)
                .add("email", email)
                .add("serviceLevel", serviceLevel)
                .add("ext1", ext1)
                .add("ext2", ext2)
                .add("ext3", ext3)
                .add("ext4", ext4)
                .add("ext5", ext5)
                .add("crtTime", crtTime)
                .add("updTime", updTime)
                .toString();
    }

}
