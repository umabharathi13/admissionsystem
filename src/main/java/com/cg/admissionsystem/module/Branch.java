package com.cg.admissionsystem.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BranchEntity class
 * 
 * @author Arivazhagan
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

	/**
	 * Creating Instance variables of class Branch
	 */

	@Id
	private int branchId;
	private String branchName;
	private String branchDescription;

}