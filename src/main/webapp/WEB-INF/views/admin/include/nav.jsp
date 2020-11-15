<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside class="left-sidebar" data-sidebarbg="skin6">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <!-- User Profile-->
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="/admin/main" aria-expanded="false"><i class="mr-3 far fa-clock fa-fw"
                                    aria-hidden="true"></i><span class="hide-menu">대시보드</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="/admin/member" aria-expanded="false">
                                <i class="mr-3 fa fa-user" aria-hidden="true"></i><span
                                    class="hide-menu">회원정보확인</span></a>
                        </li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="/admin/board" aria-expanded="false"><i class="mr-3 fa fa-table"
                                    aria-hidden="true"></i><span class="hide-menu">게시판정보확인</span></a></li>
                        <li class="sidebar-item"> <a class="sidebar-link waves-effect waves-dark sidebar-link"
                                href="/admin/channel" aria-expanded="false"><i class="mr-3 fa fa-font"
                                    aria-hidden="true"></i><span class="hide-menu">채널정보확인</span></a></li>
                        <li class="sidebar-item">
                        <div class="dropdown">
                        	
						<button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">
						<i class="mr-3 fa fa-globe"
                                    aria-hidden="true"></i><span class="hide-menu">영상관리</span>
                         </button>
                         
                          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						    <a class="dropdown-item" href="/admin/video">영상리스트확인</a>
						    <a class="dropdown-item" href="/admin/video/registerForm">영상추가</a>
						    <a class="dropdown-item" href="#">Something else here</a>
 						 </div>
                        
                        </div>
                        
                        </li>
                        
                 		<li class="sidebar-item">
                        <div class="dropdown">
                        	
						<button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">
						<i class="mr-3 fa fa-columns"
  				 			aria-hidden="true">
  				 	    </i><span class="hide-menu">유니즈관리</span>
                         </button>
                         
                          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						    <a class="dropdown-item" href="/admin/uniz/uniz">Uniz관리</a>
						    <a class="dropdown-item" href="/admin/uniz/unizLayer">UnizLayerList관리</a>
						    <a class="dropdown-item" href="#">Something else here</a>
 						 </div>
                        
                        </div>
                        
                        </li>
                        <li class="sidebar-item">
                        <div class="dropdown">
                        	
						<button style="border: 0px; background-color: white;"class="sidebar-link waves-effect waves-dark sidebar-link dropdown-toggle" aria-haspopup="true" aria-expanded="false"  data-toggle="dropdown">
						<i class="mr-3 fa fa-columns"
  				 			aria-hidden="true">
  				 	    </i><span class="hide-menu">위니즈관리</span>
                         </button>
                         
                          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						    <a class="dropdown-item" href="/admin/wniz">Wniz관리</a>
						    <a class="dropdown-item" href="/admin/wniz/uwmatch">UWMatchList관리</a>
						    <a class="dropdown-item" href="#">Something else here</a>
 						 </div>
                        
                        </div>
                        
                        </li>
                    </ul>

                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>